package org.zstack.sdk;

import java.util.HashMap;
import java.util.Map;

public class CreateResourcePriceAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public CreateResourcePriceResult value;

        public Result throwExceptionIfError() {
            if (error != null) {
                throw new ApiException(
                    String.format("error[code: %s, description: %s, details: %s]", error.code, error.description, error.details)
                );
            }
            
            return this;
        }
    }

    @Param(required = true, validValues = {"cpu","memory","rootVolume","dataVolume"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String resourceName;

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String resourceUnit;

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String timeUnit;

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, numberRange = {0,-1}, noTrim = false)
    public double price;

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String accountUuid;

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, numberRange = {0,-1}, noTrim = false)
    public java.lang.Long dateInLong;

    @Param(required = false)
    public java.util.List systemTags;

    @Param(required = false)
    public java.util.List userTags;

    @Param(required = true)
    public String sessionId;

    public long timeout;
    
    public long pollingInterval;


    public Result call() {
        ApiResult res = ZSClient.call(this);
        Result ret = new Result();
        if (res.error != null) {
            ret.error = res.error;
            return ret;
        }
        
        CreateResourcePriceResult value = res.getResult(CreateResourcePriceResult.class);
        ret.value = value == null ? new CreateResourcePriceResult() : value;
        return ret;
    }

    public void call(final Completion<Result> completion) {
        ZSClient.call(this, new InternalCompletion() {
            @Override
            public void complete(ApiResult res) {
                Result ret = new Result();
                if (res.error != null) {
                    ret.error = res.error;
                    completion.complete(ret);
                    return;
                }
                
                CreateResourcePriceResult value = res.getResult(CreateResourcePriceResult.class);
                ret.value = value == null ? new CreateResourcePriceResult() : value;
                completion.complete(ret);
            }
        });
    }

    Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "POST";
        info.path = "/billings/prices";
        info.needSession = true;
        info.needPoll = true;
        info.parameterName = "params";
        return info;
    }

}
