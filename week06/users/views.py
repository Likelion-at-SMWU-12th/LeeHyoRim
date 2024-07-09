from rest_framework import status, generics
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework.authtoken.models import Token
from django.contrib.auth import authenticate, logout
from rest_framework.permissions import IsAuthenticated
from .models import User
from .serializers import UserSerializer

class SignUpView(generics.CreateAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer

class LoginView(APIView):
    def post(self, request):
        username = request.data.get('username')
        password = request.data.get('password')
        user = authenticate(username=username, password=password)
        if user is not None:
            token, created = Token.objects.get_or_create(user=user)
            return Response({'status': 200, 'message': '로그인되었습니다', 'data': {'token': token.key}})
        return Response({'status': 400, 'message': '아이디 또는 비밀번호가 잘못되었습니다'}, status=status.HTTP_400_BAD_REQUEST)

class LogoutView(APIView):

    def get(self, request):
        logout(request)
        return Response({'status': 200, 'message': '로그아웃되었습니다'})


class UserProfileView(APIView):
    def get(self, request, user_id):
        try:
            user = User.objects.get(id=user_id)
            serializer = UserSerializer(user)
            return Response(serializer.data)
        except User.DoesNotExist:
            return Response({'status': 404, 'message': '사용자를 찾을 수 없습니다'}, status=status.HTTP_404_NOT_FOUND)

    def put(self, request, user_id):
        try:
            user = User.objects.get(id=user_id)
            serializer = UserSerializer(user, data=request.data, partial=True)
            if serializer.is_valid():
                serializer.save()
                return Response(serializer.data)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
        except User.DoesNotExist:
            return Response({'status': 404, 'message': '사용자를 찾을 수 없습니다'}, status=status.HTTP_404_NOT_FOUND)
