package mavanExample;
//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
*/
public class test1 {

    private String projectBaseDirectory = "C:\\Users\\eyal.kopelevich\\workspace\\project5";
    protected Client client = null;
    protected GridClient grid = null;
//    private String password = "eyJ4cC51IjoyMzc0LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MTY4Njk4ODUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.ZxoKq-TS4puDw_73gYPhF_ELyh4iyzWqVs-mB5SRKKg";

    @Before
    public void setUp(){
        // In case your user is assign to a single project you can provide an empty string, 
        // otherwise please specify the project name
        grid = new GridClient("eyalk", "Admin1234", "default", "cloud.experitest.com",443, true);
        client = grid.lockDeviceForExecution("chrome", "@os='android'", 10, 50000);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "chrome");
    }

    @Test
    public void testchrome(){
        // This command "setDevice" is not applicable for GRID execution 
//        if(client.install("com.experitest.ExperiBank/.LoginActivity", true, false)){
//            // If statement
//        }
        client.launch("com.experitest.ExperiBank/.LoginActivity", true, false);
    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
