package com.Prana.KalameRoyal.service;

import com.Prana.KalameRoyal.domain.Package;
import com.Prana.KalameRoyal.domain.Word;

import java.security.PrivateKey;
import java.util.List;

public interface PackageService {

    Package createPackage(Package pack);

    List<Package> getAllPackages();

    Package findById(String id);

    Boolean hiddenWord(String packageId, String wordId, int tedadHorud);

    Word editWord(String packageId, Word word);

    Package changePackageFinalState(String packageId);

    Package update(Package pack);
}
