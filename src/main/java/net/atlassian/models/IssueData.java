package net.atlassian.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class IssueData {
    private String summary;
    private String description;
}
