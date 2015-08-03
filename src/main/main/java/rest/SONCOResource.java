package rest;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * This class realizes SONCO REST application programming interface
 *
 * @author Harrison Mfula
 * @since 26.7.2015.
 */
@Path("/service")
public class SONCOResource {



    /**
     * Sample call:
     * http://localhost:8080/socc/rest/service/optimization-result
     * Sample result:
     * [{"id":1,"name":"Cell load","value":"30"},{"id":2,"name":"Ho attempts","value":"75"},
     * {"id":3,"name":"Cell Edge EcN0","value":"75"},{"id":3,"name":"RAB Offset","value":"30"}]
     */

    @GET
    @Path("/optimization-result")
    public Response getKpis() throws JSONException, InterruptedException {
        //use client to call job-server
//        SparkClusterAccess dataAccess = new SparkClusterAccess();
//        dataAccess.createSonJobContextIfNeeded();
//        dataAccess.runSonJob();
//        Thread.sleep(2000);
//        jsonArray = dataAccess.processResult();
//        System.out.println("I did it, heyyyy!");
//        return Response.status(200)
//                .entity(jsonArray)
//                .build();
       return getOldStyleResponse();
    }

    private Response getOldStyleResponse() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("name", "Cell load");
        jsonObject.put("value", "70.5");
        jsonArray.put(jsonObject);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id", 2);
        jsonObject1.put("name", "Ho attempts");
        jsonObject1.put("value", "80");
        jsonArray.put(jsonObject1);

        JSONObject cellEdgeEcNo = new JSONObject();
        cellEdgeEcNo.put("id", 3);
        cellEdgeEcNo.put("name", "Cell Edge EcN0");
        cellEdgeEcNo.put("value", "15");
        jsonArray.put(cellEdgeEcNo);
        return Response.status(200)

                .entity(jsonArray)
                .build();
    }


}
