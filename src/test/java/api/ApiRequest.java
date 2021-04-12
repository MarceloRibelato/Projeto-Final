package api;

import static io.restassured.RestAssured.given;

public class ApiRequest extends ApiUtils implements ApiVerbos {

    @Override
    public void GET() {

        response = given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .params(params)
                .get(uri);

        super.log("GET");

    }


    @Override
    public void POST() {

        response = given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .params(params)
                .body(body.toString())
                .post(uri);

        super.log("POST");

    }

    @Override
    public void PUT() {

        response = given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .params(params)
                .body(body.toString())
                .put(uri);

        super.log("PUT");

    }

    @Override
    public void DELETE() {
        response = given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .params(params)
                .body(body.toString())
                .delete(uri);

        super.log("DELETE");

    }

    @Override
    public void PATCH() {

        response = given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .params(params)
                .body(body.toString())
                .patch(uri);

        super.log("PATCH");

    }
}
