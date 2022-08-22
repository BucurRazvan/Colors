package ColorTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGBA {

    private String red;
    private String green;
    private String blue;
    private String opacity="";
    //-----------------------------------------------Constructor----------------------------------------

    /**
     * Constructor for an RGBA object
     * @param input : String following the rgb/rgba format
     * */
    public RGBA(String input){
        Pattern rgbValue = Pattern.compile("[0-9.]{1,3}");
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
     * Constructor for a RGBA object containing the color white;
     */
    public RGBA(){
        this.red = "255";
        this.green = "255";
        this.blue ="255";
        this.opacity = "";
    }


    //-----------------------------------------------Getters---------------------------------------------

    public String getOpacity() {
        return opacity;
    }


    public String getBlue() {
        return blue;
    }

    public String getGreen() {
        return green;
    }

    public String getRed() {
        return red;
    }
    //------------------------------------------------Setters----------------------------------------------

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public void setRed(String red) {
        this.red = red;
    }

    //----------------------------------------------Conversion Methods--------------------------------------------

    /**
     * Converts the red rgb value into its hexadecimal counterpart
     * @return tempString - String containing hexadecimal value
     */
    public String redValToHex() {
        Integer temp = Integer.parseInt(this.getRed());
        String tempString = Integer.toHexString(temp);
        if (temp < 16) {

            tempString = "0" + tempString;

        }
        return tempString;
    }

    /**
     * Converts the green rgb value into its hexadecimal counterpart
     * @return tempString - String containin hexadecimal value
     */
    public String greenValToHex() {
        Integer temp = Integer.parseInt(this.getGreen());
        String tempString = Integer.toHexString(temp);
        if (temp < 16) {

            tempString = "0" + tempString;

        }
        return tempString;
    }

    /**
     * Converts the blue rgb value into its hexadecimal counterpart
     * @return tempString - String containing hexadecimal value
     */
    public String blueValToHex() {
        Integer temp = Integer.parseInt(this.getBlue());
        String tempString = Integer.toHexString(temp);
        if (temp < 16) {

            tempString = "0" + tempString;

        }
        return tempString;
    }

    /**
     * Converts the opacity rgb value into its hexadecimal counterpart
     * @return tempString - String containing hexadecimal value for opacity, empty if opacity property is not set for the current object
     */
    public String opacityToHex(){
        if(this.opacity!="")
        {Float temp = Float.parseFloat(this.getOpacity());
              Integer b = (int) Math.ceil(temp*255);
                String tempString = Integer.toHexString(b);
                if (b < 16) {

                    tempString = "0" + tempString;

                }
                return tempString;}
        else
            return "";
    }

    /**
     * Creates a Hexadecimal counterpart for the current RGBA object
     * @return color - Hexadecimal object
     */
    public Hexadecimal rgbaToHexadecimalObj(){
        Hexadecimal color = new Hexadecimal();
        color.setRed(this.redValToHex());
        color.setGreen(this.greenValToHex());
        color.setBlue(this.blueValToHex());
        color.setOpacity(this.opacityToHex());
        return color;
    }

    /**
     * Converts current rgb/rgba value to a hexadecimal string
     * @return string containing the hexadecimal counterpart of the current object
     */
    public String rgbaToHexadecimalStr(){
        if (this.opacity !="")return "#" + redValToHex() + greenValToHex() +blueValToHex()+opacityToHex();
        else  return "#" + redValToHex() + greenValToHex() +blueValToHex();
    }

    /**
     *
     * @return string containing rgb/rgba code of current object
     */
    public String getRGBACode(){
            return "rgb("+this.getRed()+" "+this.getGreen()+" "+this.getBlue()+ " "+this.getOpacity()+")";
    }



}
