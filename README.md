# 🚗 Sistema de Alquiler de Vehículos

Sistema web para la gestión integral de alquiler de vehículos: búsqueda de disponibilidad, reservas con pago parcial o total, gestión de flota, dashboard de ocupación, reportes PDF y analítica de categorías.

> **Curso:** SIG-116
> **Docente:** Lic. Rodrigo Alave Chapi

---

## 📋 Tabla de Contenidos

- [Descripción](#-descripción)
- [Características](#-características)
- [Historias de Usuario](#-historias-de-usuario)
- [Arquitectura](#-arquitectura)
- [Stack Tecnológico](#-stack-tecnológico)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Modelo de Datos](#-modelo-de-datos)
- [Instalación](#-instalación)
- [Configuración](#-configuración)
- [Uso](#-uso)
- [Scripts Disponibles](#-scripts-disponibles)
- [Testing](#-testing)
- [Despliegue](#-despliegue)
- [Documentación Adicional](#-documentación-adicional)
- [Equipo](#-equipo)
- [Licencia](#-licencia)

---

## 📖 Descripción

Un cliente busca un vehículo disponible por fechas, lo reserva y paga un depósito o el alquiler completo según las políticas definidas. El administrador gestiona la flota, su disponibilidad y su estado (en mantenimiento, alquilado, disponible). El dashboard muestra la tasa de ocupación de la flota; los reportes PDF detallan ingresos por vehículo y por período; la analítica básica detecta qué categorías de vehículo se alquilan con más frecuencia.

**Actores principales:**
- **Cliente:** busca, reserva, paga, cancela.
- **Administrador:** gestiona flota, políticas, dashboard, reportes y analítica.

---

## ✨ Características

### Para el Cliente
- 🔍 Búsqueda de vehículos por rango de fechas, categoría y transmisión en tiempo real.
- 🖼️ Vista detallada con galería de fotos, ficha técnica y cálculo de precio total.
- 💳 Reserva con pago de depósito o total vía Stripe.
- 📄 Contrato digital y confirmación por email.
- 🧾 Comprobante en PDF con código QR e instrucciones de recogida.
- ❌ Cancelación con política de reembolso configurable.

### Para el Administrador
- 🚙 CRUD completo de vehículos con cambio de estado e historial de mantenimiento.
- ⚙️ Definición de políticas de alquiler (edad mínima, depósito, seguro).
- 📊 Dashboard con tasa de ocupación por día/semana, filtros por categoría y exportable.
- 📑 Reportes PDF de ingresos por vehículo y período con comparativa mes anterior.
- 📈 Analítica de categorías más alquiladas, ranking y estacionalidad.

---

## 📌 Historias de Usuario

| ID | Rol | Historia | Criterios de Aceptación |
|----|-----|----------|-------------------------|
| **U1** | Cliente | Como cliente, quiero buscar vehículos disponibles por rango de fechas y tipo. | Filtros por fecha, categoría, transmisión; resultados en tiempo real. |
| **U2** | Cliente | Como cliente, quiero ver detalles del vehículo (fotos, características, precio por día). | Galería de imágenes; ficha técnica; cálculo de precio total por días. |
| **U3** | Cliente | Como cliente, quiero reservar y pagar un depósito o el total según políticas. | Stripe con opción de pago parcial; contrato digital; confirmación por email. |
| **U4** | Cliente | Como cliente, quiero recibir un comprobante y las instrucciones de recogida. | PDF con código QR; mapa de sucursal; horarios de atención. |
| **U5** | Cliente | Como cliente, quiero cancelar mi reserva y conocer la política de reembolso. | Cancelación con reglas configurables; reembolso automático vía Stripe. |
| **U6** | Administrador | Como administrador, quiero gestionar la flota (altas, bajas, estado: disponible/mantenimiento/alquilado). | CRUD de vehículos; cambio de estado; historial de mantenimiento. |
| **U7** | Administrador | Como administrador, quiero definir políticas de alquiler (edad mínima, depósito, seguro). | Configuración global; validación en checkout; términos y condiciones. |
| **U8** | Administrador | Como administrador, quiero un dashboard con tasa de ocupación de la flota. | Gráfico de ocupación por día/semana; filtros por categoría; exportable. |
| **U9** | Administrador | Como administrador, quiero reportes PDF de ingresos por vehículo y período. | Reporte detallado; comparativa mes anterior; envío programado. |
| **U10** | Administrador | Como administrador, quiero analítica básica de categorías de vehículo más alquiladas. | Ranking de categorías; estacionalidad; integración con analítica. |

---

## 🏛️ Arquitectura

El proyecto sigue una **Arquitectura Onion** (cebolla) con separación estricta de capas y dependencias que apuntan hacia el dominio.
