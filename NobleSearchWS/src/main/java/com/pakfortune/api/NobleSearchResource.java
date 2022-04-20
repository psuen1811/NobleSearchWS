package com.pakfortune.api;

import com.pakfortune.service.NobleSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nobles")
public class NobleSearchResource {

    @GetMapping(value = "{stemBranch}")
    public String getNobleSearchResult(@PathVariable("stemBranch") String value) {
        NobleSearchService nobleSearchService = new NobleSearchService();
        return nobleSearchService.getNobles(value).toString();
    }
}
