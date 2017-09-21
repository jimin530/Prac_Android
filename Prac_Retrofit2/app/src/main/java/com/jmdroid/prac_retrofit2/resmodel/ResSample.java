package com.jmdroid.prac_retrofit2.resmodel;

import com.jmdroid.prac_retrofit2.model.SampleModel;

import java.util.List;

/**
 * Created by jimin on 2017. 9. 21..
 */

public class ResSample {
    Response response;

    public ResSample(Response response) {
        this.response = response;
    }

    public ResSample() {

    }

    public Response getResponse() {
        return response;
    }

    public class Response {
        Header header;
        Body body;


        public Header getHeader() {
            return header;
        }

        public Body getBody() {
            return body;
        }

        public class Header {
            String resultCode;
            String resultMsg;

            public String getResultCode() {
                return resultCode;
            }

            public String getResultMsg() {
                return resultMsg;
            }
        }
        public class Body {
            Items items;
            int numOfRows;
            int pageNo;
            int totalCount;

            public Items getItems() {
                return items;
            }

            public int getNumOfRows() {
                return numOfRows;
            }

            public int getPageNo() {
                return pageNo;
            }

            public int getTotalCount() {
                return totalCount;
            }

            public class Items {
                List<SampleModel> item;

                public List<SampleModel> getItem() {
                    return item;
                }

                public void setItem(List<SampleModel> item) {
                    this.item = item;
                }
            }
        }
    }
}
