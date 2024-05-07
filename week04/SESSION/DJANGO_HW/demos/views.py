from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def hobby(request):
    #return HttpResponse('요즘 나의 취미')
    return render(request, 'temp.html')