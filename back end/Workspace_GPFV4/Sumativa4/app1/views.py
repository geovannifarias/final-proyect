from django.shortcuts import render , redirect
from app1.models import Categoria , Producto


#Importaciones de rest-framework
from app1.serializers import SerializersProducto , SerializersCategoria
from rest_framework.response import Response
from rest_framework import status
from rest_framework.views import APIView
from django.http import Http404


#CLASS BASED VIEWS PRODUCTO
class ListaProducto(APIView):

    def get(self , request):
        producto = Producto.objects.all()
        serializer = SerializersProducto(producto , many=True)
        return Response(serializer.data)

    def post(self , request):
        serializer = SerializersProducto(data = request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data , status=status.HTTP_201_CREATED)
        return Response(serializer.errors , status=status.HTTP_400_BAD_REQUEST)


class DetalleProducto(APIView):

    def get_object(self , pk):
        try:
            return Producto.objects.get(pk=pk)
        except Producto.DoesNotExist:
            raise Http404

    def get(self , request , pk):
        producto = self.get_object(pk)
        serializer = SerializersProducto(producto)
        return Response(serializer.data)

    def put(self , request , pk):
        producto = self.get_object(pk)
        serializer = SerializersProducto(producto , data = request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors , status=status.HTTP_400_BAD_REQUEST)

    def delete(self , request , pk):
        producto = self.get_object(pk)
        producto.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

#CLASS BASED VIEWS CATEGORIA
class ListaCategoria(APIView):

    def get(self , request):
        categoria = Categoria.objects.all()
        serializer = SerializersProducto(categoria , many=True)
        return Response(serializer.data)

    def post(self , request):
        serializer = SerializersCategoria(data = request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data , status=status.HTTP_201_CREATED)
        return Response(serializer.errors , status=status.HTTP_400_BAD_REQUEST)


class DetalleCategoria(APIView):

    def get_object(self , pk):
        try:
            return Categoria.objects.get(pk=pk)
        except Categoria.DoesNotExist:
            raise Http404

    def get(self , request , pk):
        categoria = self.get_object(pk)
        serializer = SerializersCategoria(categoria)
        return Response(serializer.data)

    def put(self , request , pk):
        categoria = self.get_object(pk)
        serializer = SerializersCategoria(categoria , data = request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors , status=status.HTTP_400_BAD_REQUEST)

    def delete(self , request , pk):
        categoria = self.get_object(pk)
        categoria.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)