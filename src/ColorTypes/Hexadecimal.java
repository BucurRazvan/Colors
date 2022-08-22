package ColorTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hexadecimal {
    private String red;
    private String blue;
    private String green;
    private String opacity="";

    //--------------------------------------------------Constructors------------------------------------------

    /**
     * Constructor for a Hexadecimal color object
     * @param input : String containing a hexacolor code, does not support short form (e.g #fff)
     */
    public Hexadecimal(String input){
        Pattern rgbValue = Pattern.compile("[a-zA-Z1-9]{2}");
        Matcher matcher = rgbValue.matcher(input);
        matcher.find();
        this.red = matcher.group();
        matcher.find();
        this.green = matcher.group();
        matcher.find();
        this.blue = matcher.group();
        if(matcher.find())
            this.opacity= matcher.group();

    }

    /**
     * Constructor for a white Hexadecimal color object
     */
    public Hexadecimal(){
        this.red = "FF";
        this.green = "FF";
        this.blue ="FF";
        this.opacity = "";
    }
    //--------------------------------------------------Getters------------------------------------------------

    public String getBlue() {
        return blue;
    }

    public String getGreen() {
        return green;
    }

    public String getOpacity() {
        return opacity;
    }

    public String getRed() {
        return red;
    }
    //----------------------------------------------------Setters--------------------------------------------------


    public void setRed(String red) {
        this.red = red;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }

    public void setGreen(String green) {
        this.green = green;
    }
    //-------------------------------------------------------Methods-------------------------------------------------

    /**
     * Converts red field to rgb value
     * @return String containing rgb value
     */
    public String redValToRGB(){
        Integer temp = Integer.valueOf(this.getRed(),16);
        return temp.toString();
    }
    /**
     * Converts green field to rgb value
     * @return String containing rgb value
     */
    public String greenValToRGB(){
        Integer temp = Integer.valueOf(this.getGreen(),16);
        return temp.toString();
    }
    /**
     * Converts blue field to rgb value
     * @return String containing rgb value
     */
    public String blueValToRGB(){
        Integer temp = Integer.valueOf(this.getBlue(),16);
        return temp.toString();
    }

    /**
     * Converts opacity field to rgb value if present
     * @return String containing a value from 0-1 if opacity of current object is specified, empty string otherwise
     */
    public String opacityValtoRGBA(){
        if(this.opacity!="")
        {
            Integer temp = Integer.valueOf(this.getOpacity(),16);
            Float  tempfloat = (float)temp/255;
            return tempfloat.toString();

        }
        else
            return "";
    }
    /**
     * Creates a RGBA counterpart for the current Hexadecimal object
     * @return color - RGBA object
     */
    public RGBA hexToRGBAObj(){
        RGBA temp = new RGBA();
        temp.setRed(this.redValToRGB());
        temp.setGreen(this.greenValToRGB());
        temp.setBlue(this.blueValToRGB());
        temp.setOpacity(this.opacityValtoRGBA());
        return temp;
    }
    /**
     *
     * @return string containing hex code of current object
     */
    public String hexToRGBAString(){
        if (this.getOpacity()!=""){
            return "rgb("+this.redValToRGB()+" "+this.greenValToRGB()+" "+this.blueValToRGB()+" "+this.opacityValtoRGBA()+")";}
        else
            return "rgb("+this.redValToRGB()+" "+this.greenValToRGB()+" "+this.blueValToRGB()+ ")";
    }
}
