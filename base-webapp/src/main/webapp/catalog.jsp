<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>Главная страница</title>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="main">EShop</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="main">Главная</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="catalog">Каталог товаров</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="product">Товар</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cart">Корзина</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="order">Оформление заказа</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="company">О компании</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h3>▍Каталог товаров</h3>
    <div class="row py-2">
        <div class="col-12">
            <a class="btn btn-primary" href="addproduct">Добавить товар</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col">Название</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Цена</th>
                        <th scope="col">Действие</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Процессор AMD Ryzen 5 3600</td>
                        <td>сокет SocketAM4, ядро Matisse, ядер — 6, потоков — 12, L3 кэш 32Мб, частота 3.6 ГГц и 4.2 ГГц в режиме Turbo, техпроцесс 7нм, поддержка памяти DDR4 каналов памяти — 2, множитель не заблокирован, контроллер PCI Express 4.0, поставка OEM</td>
                        <td>12 890 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Видеокарта SAPPHIRE AMD Radeon RX 5700</td>
                        <td>AMD Radeon RX 5700 ; частота процессора: 1540 МГц (1750 МГц, в режиме Boost); частота памяти: 14000МГц; объём видеопамяти: 8Гб; тип видеопамяти: GDDR6; поддержка: CrossFireX; DirectX 12/OpenGL 4.5; доп. питание: 6+8 pin; блок питания не менее: 600Вт; тип поставки: Ret</td>
                        <td>25 390 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Модуль памяти CORSAIR Vengeance LPX 2x 8Гб</td>
                        <td>288-pin; частота: 3200; латентность: CL16; форм-фактор: DIMM; комплект модулей для идеальной совместной работы, оснащается радиатором для эффективного охлаждения, тип поставки: Ret</td>
                        <td>5 840 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td>Планшет HUAWEI MediaPad M5 10.0 Lite</td>
                        <td>сенсорный экран 10.1" (25.7 см), разрешение: 1920 x 1200, Multitouch, поддержка 3G, поддержка 4G, Wi-Fi, Bluetooth, GPRS, EDGE, GPS, A-GPS, ГЛОНАСС, основная камера: 8Мп, фронтальная камера: 8Мп, fingerprint, встроенная память: 32Гб, операционная система: Android 8.0</td>
                        <td>19 990 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">5</th>
                        <td>Смарт-часы AMAZFIT Bip Lite, 1.28", черный</td>
                        <td>дисплей: 1.28", 176 х 176 точек; совместимые операционные системы: iOS 8.0, Android 4.4 и выше</td>
                        <td>3 690 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">6</th>
                        <td>Монитор HP 24o 24"</td>
                        <td>экран: 24", матрица TN с разрешением 1920×1080, отношением сторон 16:9, яркостью 250кд/м2, временем отклика 1мс, разъем D-SUB (VGA), DVI, HDMI</td>
                        <td>6 490 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">7</th>
                        <td>Корпус ATX FORMULA CT-732, Midi-Tower, без БП, черный</td>
                        <td>размер: Midi-Tower; USB 2.0: 2шт, USB 3.0: 1шт, + аудио на передней панели; внутренние 3.5"- 2шт; материал стенок — сталь/пластик, прозрачная боковая панель, 0.5мм, видеокарта длиной, до: 330мм</td>
                        <td>2 300 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">8</td>
                        <td>Наушники с микрофоном JBL T500BT, Bluetooth, накладные, черный</td>
                        <td>тип соединения: беспроводные bluetooth; акустический тип: закрытые; тип амбушюр: накладные</td>
                        <td>1 990 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">9</td>
                        <td>Игровая консоль DENDY 255 игр, Classic 8bit, черный</td>
                        <td>диск в комплекте: 255 игр</td>
                        <td>1 580 ₽</td>
                        <td>
                            <a class="btn btn-success" href="addproduct"><i class="fas fa-edit"></i></a>
                            <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>