package ru.raiffeisen.wishlist.feign.model;

import lombok.Builder;
import lombok.Data;
import ru.raiffeisen.wishlist.model.ProductType;

import java.util.List;

@Data
public class JiraCreateIssueRequest {
    public JiraCreateIssueRequest(String title, String description, ProductType product, String email) {
        this.fields = Fields.builder()
                .summary(title)
                .issuetype(Fields.Issuetype.builder().build())
                .project(Fields.Project.builder().build())
                .customfield_10047(Fields.Customfield_10047.builder()
                        .id(String.valueOf(product.getJiraProjectId()))
                        .build())
                .description(Fields.Description.builder()
                        .content(List.of(Fields.Description.ContentField.builder()
                                .content(List.of(Fields.Description.ContentField.ContentFieldInternal.builder()
                                        .text(description)
                                        .build()))
                                .build()))
                        .build())
                .reporter(Fields.Reporter.builder().build())
                .assignee(Fields.Assignee.builder().build())
                .customfield_10049(email)
                .build();
    }

    private Fields fields;

    @Data
    @Builder
    public static class Fields {
        private String summary;
        private Issuetype issuetype;
        private Project project;
        private Customfield_10047 customfield_10047;
        private Description description;
        private Reporter reporter;
        private Assignee assignee;
        private String customfield_10049;

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
            private String id;
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

        @Data
        @Builder
        public static class Assignee {
            @Builder.Default
            private String id = "5f36cca2323607003868a111";
        }
    }
}
