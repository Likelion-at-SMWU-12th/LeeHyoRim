from django.db import models
from django.contrib.auth import get_user_model

# Create your models here.

User=get_user_model()

class Post (models.Model): #Model 만들기
    image = models.ImageField(verbose_name='이미지', null=True, blank=True)
    content = models.TextField(verbose_name='내용')
    created_at = models.DateTimeField(verbose_name='작성일', auto_now_add=True)
    view_count = models.IntegerField(verbose_name='조회수', default=0)
    writer=models.ForeignKey(to=User, on_delete=models.CASCADE, verbose_name='게시글', null=True, blank=True)

class Comments(models.Model):
    author = models.CharField(max_length=100, verbose_name='작성자')
    text = models.TextField(verbose_name='댓글 내용')
    created_at = models.DateTimeField(auto_now_add=True, verbose_name='작성일')
    likes = models.IntegerField(default=0, verbose_name='좋아요 수')
    dislikes = models.IntegerField(default=0, verbose_name='싫어요 수')

class Comment(models.Model):
    content=models.TextField(verbose_name='내용')
    created_at=models.DateTimeField(verbose_name='작성일', auto_now_add=True)
    post=models.ForeignKey(to='Post', on_delete=models.CASCADE, verbose_name='게시글')
    writer=models.ForeignKey(to=User, on_delete=models.CASCADE, verbose_name='게시글', null=True)
