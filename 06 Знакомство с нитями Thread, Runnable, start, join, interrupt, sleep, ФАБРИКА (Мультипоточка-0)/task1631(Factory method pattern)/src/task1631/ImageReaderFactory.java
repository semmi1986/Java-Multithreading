package task1631;


import task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        if (imageTypes == ImageTypes.JPG)
            return new JpgReader();

        if (imageTypes == ImageTypes.BMP)
            return new BmpReader();

        if (imageTypes == ImageTypes.PNG)
            return new PngReader();

        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
