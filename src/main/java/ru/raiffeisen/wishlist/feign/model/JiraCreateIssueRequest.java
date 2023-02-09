package ru.raiffeisen.wishlist.feign.model;

import lombok.Builder;
import lombok.Data;
import ru.raiffeisen.wishlist.model.ProductType;

import java.util.List;

public class JiraCreateIssueRequest {
    public JiraCreateIssueRequest(
            String title, String description, ProductType product
    ){

    }

    private Fields fields;

    @Data
    @Builder
    public static class Fields {
        private String summary;

        @Data
        @Builder
        public static class Issuetype {
            @Builder.Default
            private String name = "Feature";
        }

        @Data
        @Builder
        public static class Project {
            @Builder.Default
            private String key = "GETFICHA";
        }

        @Data
        @Builder
        // Product
        public static class Customfield_10047 {
            private String value;
        }

        @Data
        @Builder
        public static class Description {
            @Builder.Default
            private String type = "doc";
            @Builder.Default
            private int version = 1;
            private List<ContentField> content;
            @Data
            @Builder
            public static class ContentField {
                @Builder.Default
                private String type = "paragraph";
                private List<ContentFieldInternal> content;

                @Data
                @Builder
                public static class ContentFieldInternal {
                    private String text;
                    @Builder.Default
                    private String type = "text";
                }
            }
        }

        @Data
        @Builder
        public static class Reporter {
            @Builder.Default
            private String id = "5f36cca2323607003868a111";
        }

        public static class Labels {

        }

        @Data
        @Builder
        public static class Assignee {
            @Builder.Default
            private String id = "5f36cca2323607003868a111";
        }
    }
}
