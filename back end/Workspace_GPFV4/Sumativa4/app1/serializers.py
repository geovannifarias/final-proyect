from rest_framework import serializers
from .models import Categoria , Producto

class SerializersCategoria(serializers.ModelSerializer):

    class Meta:
        model = Categoria
        fields = '__all__'

class SerializersProducto(serializers.ModelSerializer):

    class Meta:
        model = Producto
        fields = '__all__'