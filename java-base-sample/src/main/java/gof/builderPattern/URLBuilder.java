/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern;

import java.util.Map;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/7 22:26 <br>
 */
public class URLBuilder {

    private String domain;
    private String scheme;
    private String path;
    private Map<String, String> queryParam;

    private URLBuilder(Builder builder) {
        this.domain = builder.domain;
        this.scheme = builder.scheme;
        this.path = builder.path;
        this.queryParam = builder.query;
    }

    private String init() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(scheme)
                .append("//:")
                .append(domain)
                .append(path);
        String paramStr = queryParam(queryParam);

        if (!"".equals(paramStr)) {
            stringBuilder.append("?").append(paramStr);
        }
        return stringBuilder.toString();
    }

    private String queryParam(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((key, value) -> stringBuilder.append(key).append("=").append(value).append("&"));
        String s = stringBuilder.toString();
        return "".equals(s) ? "" : s.substring(0, s.length() - 1);
    }

    public static final class Builder {

//        static Builder builder = new Builder();

        private String domain;
        private String scheme;
        private String path;
        private Map<String, String> query;

        public String builder() {
            return new URLBuilder(this).init();
        }

        public Builder setDoMain(String domain){
            this.domain = domain;
            return this;
        }

        public Builder setScheme(String scheme){
            this.scheme = scheme;
            return this;
        }

        public Builder setPath(String path){
            this.path = path;
            return this;
        }

        public Builder setQuery(Map<String, String> query){
            this.query = query;
            return this;
        }
    }

}
