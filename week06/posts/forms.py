from django import forms #forms라는 모델 import
from .models import Post # Post 모델 import

# Model Forms
class PostModelForm(forms.ModelForm):
    class Meta:
        model = Post # models.py에 정의된 Post 모델 사용
        fields = '__all__' # Post 클래스의 모든 항목 가져오기

class PostBasedForm(forms.Form):
    image = forms.ImageField(label='이미지')
    content = forms.CharField(label='내용', widget=forms.Textarea)
    CATEGORY_CHOICES = [
        ('1', '일반'),
        ('2', '계정'),
    ]
    category = forms.ChoiceField(label='카테고리', choices=CATEGORY_CHOICES)