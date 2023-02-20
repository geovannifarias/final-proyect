from django.db import models

# Create your models here.

class Categoria(models.Model):

    codigocategoria = models.CharField(primary_key=True , unique=True , max_length=3)
    nombre = models.CharField(max_length=25)

class Producto(models.Model):

    codigoproducto = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=25)
    precio = models.IntegerField()
    stock = models.IntegerField()
    codigoBarra = models.IntegerField()
    codigocategoria = models.ForeignKey(Categoria , on_delete=models.CASCADE)