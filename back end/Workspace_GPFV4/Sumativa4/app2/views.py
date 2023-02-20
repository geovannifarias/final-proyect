from django.shortcuts import render , redirect
from app1.models import Categoria , Producto


#Importaciones de rest-framework
from app1.serializers import SerializersCategoria , SerializersProducto
from rest_framework.response import Response
from rest_framework import status
from rest_framework.decorators import api_view
# Create your views here.

@api_view(['GET','POST'])
def lista_Producto(request):
    if request.method == 'GET':
        producto = Producto.objects.all()
        serializer = SerializersProducto(producto , many=True)
        return Response(serializer.data)

    if request.method == 'POST':
        serializer = SerializersProducto(data= request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data , status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET','PUT','DELETE'])
def detalle_Producto(request , pk):
    try:
        producto = Producto.objects.get(pk=pk)
    except Producto.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        serializer = SerializersProducto(producto)
        return Response(serializer.data)
    
    if request.method == 'PUT':
        serializer = SerializersProducto(producto , data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors , status=status.HTTP_400_BAD_REQUEST)
    
    if request.method == 'DELETE':
        producto.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


@api_view(['GET','POST'])
def lista_Categoria(request):
    if request.method == 'GET':
        categoria = Categoria.objects.all()
        serializer = SerializersCategoria(categoria , many=True)
        return Response(serializer.data)

    if request.method == 'POST':
        serializer = SerializersCategoria(data= request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data , status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET','PUT','DELETE'])
def detalle_Categoria(request , pk):
    try:
        categoria = Categoria.objects.get(pk=pk)
    except Categoria.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        serializer = SerializersCategoria(categoria)
        return Response(serializer.data)
    
    if request.method == 'PUT':
        serializer = SerializersCategoria(categoria , data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors , status=status.HTTP_400_BAD_REQUEST)
    
    if request.method == 'DELETE':
        categoria.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)