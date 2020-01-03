package com.xsis.xsis.restapi;

import java.util.List;

import com.xsis.xsis.models.entity.UndanganView;
import com.xsis.xsis.services.IViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ViewUndanganAPI
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/view-undangan", produces = "application/json")
public class ViewUndanganAPI {

    @Autowired
    private IViewService viewService;

    @GetMapping
    public List<UndanganView> getAll() {
        return viewService.getAll();
    }

    @GetMapping("/search")
    public List<UndanganView> cariDetailUndangan(@RequestParam(name = "name") String name) {
        return viewService.searchDataByName(name);
    }

}