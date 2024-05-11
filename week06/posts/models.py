from django.db import models

# Create your models here.

class Post (models.Model): #Model 만들기
    
    image = models.ImageField(verbose_name='이미지')
    contentn = models.TextField('내용')
    created_at = models.DateTimeField('작성일')
    view_count = models.IntegerField('조회수', default=0)
    

class Comment(models.Model):
    author = models.CharField(max_length=100, verbose_name='작성자')
    text = models.TextField(verbose_name='댓글 내용')
    created_at = models.DateTimeField(auto_now_add=True, verbose_name='작성일')
    likes = models.IntegerField(default=0, verbose_name='좋아요 수')
    dislikes = models.IntegerField(default=0, verbose_name='싫어요 수')
