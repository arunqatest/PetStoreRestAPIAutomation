/*
 * package api.utilities;
 * 
 * import org.testng.Assert; import org.testng.annotations.Test;
 * 
 * import api.endpoints.UserEndPoints; import api.payload.User; import
 * io.restassured.response.Response;
 * 
 * public class DataProviderTest {
 * 
 * @Test(priority=1, dataProvider="Data", dataProviderClass =
 * DataProviderTest.class) public void testPostUser(String userid, String uname,
 * String fname, String lname, String email, String pwd, String phone) {
 * 
 * User userpayload = new User();
 * 
 * userpayload.setId(Integer.parseInt(userid)); userpayload.setUsername(uname);
 * userpayload.setFirstName(fname); userpayload.setLastName(lname);
 * userpayload.setEmail(email); userpayload.setPassword(pwd);
 * userpayload.setPhone(phone);
 * 
 * 
 * Response response = UserEndPoints.createUser(userpayload);
 * Assert.assertEquals(response.getStatusCode(), 200);
 * 
 * }
 * 
 * @Test(priority=2, dataProvider="UserNames", dataProviderClass =
 * DataProviderTest.class) public void testDeleteUser(String uname) {
 * 
 * Response res = UserEndPoints.deleteUser(uname);
 * Assert.assertEquals(res.getStatusCode(), 200); }
 * 
 * }
 */