package ru.geekbrains.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(AppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        logger.info("Context initialization: " + ctx.getContextPath());

        String jdbcConnectionString = ctx.getInitParameter("jdbcConnectionString");
        String dbUsername = ctx.getInitParameter("dbUsername");
        String dbPassword = ctx.getInitParameter("dbPassword");

        try {
            Connection conn = DriverManager.getConnection(jdbcConnectionString, dbUsername, dbPassword);
            ProductRepository productRepository = new ProductRepository(conn);

            ctx.setAttribute("connection", conn);
            ctx.setAttribute("productRepository", productRepository);

            if (productRepository.findAll().size() == 0){
                productRepository.insert(new Product(-1L, "Процессор AMD Ryzen 5 3600", "Dсокет SocketAM4, ядро Matisse, ядер — 6, потоков — 12, L3 кэш 32Мб, частота 3.6 ГГц и 4.2 ГГц в режиме Turbo, техпроцесс 7нм, поддержка памяти DDR4 каналов памяти — 2, множитель не заблокирован, контроллер PCI Express 4.0, поставка OEM", new BigDecimal(12890)));
                productRepository.insert(new Product(-1L, "Видеокарта SAPPHIRE AMD Radeon RX 5700", "AMD Radeon RX 5700 ; частота процессора: 1540 МГц (1750 МГц, в режиме Boost); частота памяти: 14000МГц; объём видеопамяти: 8Гб; тип видеопамяти: GDDR6; поддержка: CrossFireX; DirectX 12/OpenGL 4.5; доп. питание: 6+8 pin; блок питания не менее: 600Вт; тип поставки: Ret", new BigDecimal(25390)));
                productRepository.insert(new Product(-1L, "Модуль памяти CORSAIR Vengeance LPX 2x 8Гб", "288-pin; частота: 3200; латентность: CL16; форм-фактор: DIMM; комплект модулей для идеальной совместной работы, оснащается радиатором для эффективного охлаждения, тип поставки: Ret", new BigDecimal(5840)));
                productRepository.insert(new Product(-1L, "Планшет HUAWEI MediaPad M5 10.0 Lite", "сенсорный экран 10.1\" (25.7 см), разрешение: 1920 x 1200, Multitouch, поддержка 3G, поддержка 4G, Wi-Fi, Bluetooth, GPRS, EDGE, GPS, A-GPS, ГЛОНАСС, основная камера: 8Мп, фронтальная камера: 8Мп, fingerprint, встроенная память: 32Гб, операционная система: Android 8.0", new BigDecimal(19990)));
                productRepository.insert(new Product(-1L, "Смарт-часы AMAZFIT Bip Lite, 1.28\", черный", "дисплей: 1.28\", 176 х 176 точек; совместимые операционные системы: iOS 8.0, Android 4.4 и выше", new BigDecimal(3690)));
                productRepository.insert(new Product(-1L, "Монитор HP 24o 24\"", "экран: 24\", матрица TN с разрешением 1920×1080, отношением сторон 16:9, яркостью 250кд/м2, временем отклика 1мс, разъем D-SUB (VGA), DVI, HDMI", new BigDecimal(6490)));
                productRepository.insert(new Product(-1L, "Корпус ATX FORMULA CT-732, Midi-Tower, без БП, черный", "размер: Midi-Tower; USB 2.0: 2шт, USB 3.0: 1шт, + аудио на передней панели; внутренние 3.5\"- 2шт; материал стенок — сталь/пластик, прозрачная боковая панель, 0.5мм, видеокарта длиной, до: 330мм", new BigDecimal(2300)));
                productRepository.insert(new Product(-1L, "Наушники с микрофоном JBL T500BT, Bluetooth, накладные, черный", "тип соединения: беспроводные bluetooth; акустический тип: закрытые; тип амбушюр: накладные", new BigDecimal(1990)));
                productRepository.insert(new Product(-1L, "Игровая консоль DENDY 255 игр, Classic 8bit, черный", "диск в комплекте: 255 игр", new BigDecimal(1580)));
            }
        } catch (SQLException e) {
            logger.error("", e);
        }


    }
}
