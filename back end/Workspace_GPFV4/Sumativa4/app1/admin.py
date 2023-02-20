from django.contrib import admin
from .models import Categoria , Producto

# Register your models here.

class AdminCategoria(admin.ModelAdmin):
    list_display = ('codigocategoria','nombre')
admin.site.register(Categoria,AdminCategoria)

class AdminProducto(admin.ModelAdmin):
    list_display = ('codigoproducto','nombre','precio','stock','codigoBarra','codigocategoria')
admin.site.register(Producto,AdminProducto)

