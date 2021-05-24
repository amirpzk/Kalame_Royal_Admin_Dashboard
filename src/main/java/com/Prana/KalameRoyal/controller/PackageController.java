package com.Prana.KalameRoyal.controller;

import com.Prana.KalameRoyal.Authentication.AuthenticationService;
import com.Prana.KalameRoyal.domain.Package;
import com.Prana.KalameRoyal.domain.Word;
import com.Prana.KalameRoyal.model.*;
import com.Prana.KalameRoyal.service.PackageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/packages")
public class PackageController {

    @Autowired
    private PackageServiceImp service;
    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping(value = "/create-package")
    public ResponseEntity<Package> createPackage(@RequestBody Package pack,
                                                 @RequestHeader("token") String token) throws Exception {
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Package created = service.createPackage(pack);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<PackagePaginationResponse>> getAllPackages(@RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        List<Package> packages = service.getAllPackages();
        List<PackagePaginationResponse> models = new ArrayList<>();
        for (Package founded : packages) {
            PackagePaginationResponse model = new PackagePaginationResponse();
            model.domainToModel(founded);
            models.add(model);
        }
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping(value = "/get-package-by-id")
    public ResponseEntity<NormalModeGamePlayPackageResponse> getById(@RequestParam("packageId") String id,
                                                                     @RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Package pack = service.findById(id);
        NormalModeGamePlayPackageResponse model = new NormalModeGamePlayPackageResponse();
        model.domainToModel(pack);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping(value = "/hidden-word")
    public ResponseEntity<Boolean> visibleWord(@RequestParam("package-id") String packageId,
                                               @RequestParam("word-id") String wordId,
                                               @RequestParam("tedad-horuf") int tedadHoruf,
                                               @RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Boolean isHidden = service.hiddenWord(packageId, wordId, tedadHoruf);
        return new ResponseEntity<>(isHidden, HttpStatus.OK);
    }


    @PutMapping(value = "/edit-word")
    public ResponseEntity<WordWithInformationResponse> editWord(@RequestBody Word word,
                                            @RequestParam("package-id") String packageId,
                                            @RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Word editedWord = service.editWord(packageId, word);
        WordWithInformationResponse response = new WordWithInformationResponse();
        response.domainToModel(editedWord);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-words")
    public ResponseEntity<List<WordPaginationResponse>> paginateWords(@RequestParam("packageId") String packageId,
                                                                      @RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Package foundedPackage = service.findById(packageId);
        List<WordPaginationResponse> models = new ArrayList<>();
        List<Word> wholeWords = new ArrayList<>();
        wholeWords.addAll(foundedPackage.getThreeLetterWords());
        wholeWords.addAll(foundedPackage.getFourLetterWords());
        wholeWords.addAll(foundedPackage.getFiveLetterWords());

        for (Word wholeWord : wholeWords) {
            WordPaginationResponse model = new WordPaginationResponse();
            model.domainToModel(wholeWord);
            models.add(model);
        }

        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @PatchMapping(value = "/change-package-final-state")
    public ResponseEntity<PackageFinalStateEditionResponse> changePackageFinalState(@RequestParam("packageId") String packageId,
                                                                                    @RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Package finalReuslt = service.changePackageFinalState(packageId);
        return new ResponseEntity<>(new PackageFinalStateEditionResponse().domainToModel(finalReuslt), HttpStatus.OK);
    }


    @PutMapping(value = "/update-package")
    public ResponseEntity<Boolean> updatePackage(@RequestBody Package pack,
                                                 @RequestHeader("token") String token) throws Exception{
        if (!authenticationService.validateToken(token)){
            throw new Exception("Forbidden");
        }
        Package updatedPackage = service.update(pack);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
