import ColorTypes.Hexadecimal;
import ColorTypes.RGBA;

public class main {
    public static void main(String[] args) {
        RGBA test =new RGBA("rgb(124,3,5,)");
        Hexadecimal hexa = test.rgbaToHexadecimalObj();
        System.out.println(hexa.getRed()+hexa.getGreen()+hexa.getBlue());
        System.out.println(test.opacityToHex());
        System.out.println(test.getRGBACode());
        System.out.println(test.rgbaToHexadecimalStr());
        System.out.println(hexa.redValToRGB());
        System.out.println(hexa.opacityValtoRGBA());
        RGBA test2 = hexa.hexToRGBAObj();
        System.out.println(test2.getRGBACode());
        System.out.println(hexa.hexToRGBAString());
        Hexadecimal test3 = new Hexadecimal("#F217FF89");
        System.out.println(test3.getRed()+test3.getGreen()+test3.getBlue()+test3.getOpacity());
    }
}