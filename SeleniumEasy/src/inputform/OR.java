package inputform;import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OR {
//SimpleFormDemo-TC01
public static final String element="//*[@id=\"treemenu\"]/li/a";
public static final String inputform="//*[@id=\"treemenu\"]/li/ul/li[1]/a";
public static final String simpleform="//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a";
public static final String inputtxt="//*[@id=\"user-message\"]";
public static final String showinputtxt="//*[@id=\"get-input\"]/button";
//SimpleFormDemo-TC02
public static final String entera="//*[@id=\"sum1\"]";
public static final String enterb="//*[@id=\"sum2\"]";
public static final String addbtn="//*[@id=\"gettotal\"]/button";

//CheckBoxDemo-TC03
public static final String Checkbox="//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[2]/a";
public static final String chk="isAgeSelected";

//checkbox demo TC04

public static final String checkboxbtn="check1";

public static final String firstname="//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input";
public static final String lastname="//*[@id=\"contact_form\"]/fieldset/div[2]/div/div/input";
public static final String mailid="//*[@id=\"contact_form\"]/fieldset/div[3]/div/div/input";
public static final String phoneno="//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input";
public static final String address="//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input";
public static final String city="//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input";
public static final String drpdwn="//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select";
public static final String zip="//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input";
public static final String website="//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input";
public static final String radio="//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[1]/label/input";
public static final String comments="//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea";
public static final String submit="//*[@id=\"contact_form\"]/fieldset/div[13]/div/button";



//ajx form
public static final String name="//*[@id=\"title\"]";
public static final String comm="//*[@id=\"description\"]";
public static final String butn="//*[@id=\"btn-submit\"]";


}