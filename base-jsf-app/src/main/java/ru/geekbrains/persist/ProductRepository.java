package ru.geekbrains.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @PostConstruct
    public void init() {
        if (findAll().size() == 0){
            insert(new Product(-1L, "Процессор AMD Ryzen 5 3600", "Dсокет SocketAM4, ядро Matisse, ядер — 6, потоков — 12, L3 кэш 32Мб, частота 3.6 ГГц и 4.2 ГГц в режиме Turbo, техпроцесс 7нм, поддержка памяти DDR4 каналов памяти — 2, множитель не заблокирован, контроллер PCI Express 4.0, поставка OEM", new BigDecimal(12890)));
            insert(new Product(-1L, "Видеокарта SAPPHIRE AMD Radeon RX 5700", "AMD Radeon RX 5700 ; частота процессора: 1540 МГц (1750 МГц, в режиме Boost); частота памяти: 14000МГц; объём видеопамяти: 8Гб; тип видеопамяти: GDDR6; поддержка: CrossFireX; DirectX 12/OpenGL 4.5; доп. питание: 6+8 pin; блок питания не менее: 600Вт; тип поставки: Ret", new BigDecimal(25390)));
            insert(new Product(-1L, "Модуль памяти CORSAIR Vengeance LPX 2x 8Гб", "288-pin; частота: 3200; латентность: CL16; форм-фактор: DIMM; комплект модулей для идеальной совместной работы, оснащается радиатором для эффективного охлаждения, тип поставки: Ret", new BigDecimal(5840)));
            insert(new Product(-1L, "Планшет HUAWEI MediaPad M5 10.0 Lite", "сенсорный экран 10.1\" (25.7 см), разрешение: 1920 x 1200, Multitouch, поддержка 3G, поддержка 4G, Wi-Fi, Bluetooth, GPRS, EDGE, GPS, A-GPS, ГЛОНАСС, основная камера: 8Мп, фронтальная камера: 8Мп, fingerprint, встроенная память: 32Гб, операционная система: Android 8.0", new BigDecimal(19990)));
            insert(new Product(-1L, "Смарт-часы AMAZFIT Bip Lite, 1.28\", черный", "дисплей: 1.28\", 176 х 176 точек; совместимые операционные системы: iOS 8.0, Android 4.4 и выше", new BigDecimal(3690)));
            insert(new Product(-1L, "Монитор HP 24o 24\"", "экран: 24\", матрица TN с разрешением 1920×1080, отношением сторон 16:9, яркостью 250кд/м2, временем отклика 1мс, разъем D-SUB (VGA), DVI, HDMI", new BigDecimal(6490)));
            insert(new Product(-1L, "Корпус ATX FORMULA CT-732, Midi-Tower, без БП, черный", "размер: Midi-Tower; USB 2.0: 2шт, USB 3.0: 1шт, + аудио на передней панели; внутренние 3.5\"- 2шт; материал стенок — сталь/пластик, прозрачная боковая панель, 0.5мм, видеокарта длиной, до: 330мм", new BigDecimal(2300)));
            insert(new Product(-1L, "Наушники с микрофоном JBL T500BT, Bluetooth, накладные, черный", "тип соединения: беспроводные bluetooth; акустический тип: закрытые; тип амбушюр: накладные", new BigDecimal(1990)));
            insert(new Product(-1L, "Игровая консоль DENDY 255 игр, Classic 8bit, черный", "диск в комплекте: 255 игр", new BigDecimal(1580)));
        }
    }

    @Transactional
    public void insert(Product product) {
        em.persist(product);
    }

    @Transactional
    public void update(Product product) {
        em.merge(product);
    }

    @Transactional
    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null){
            em.remove(product);
        }

    }

    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("FROM Product", Product.class).getResultList();
    }
}
