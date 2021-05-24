package com.Prana.KalameRoyal.service;

import com.Prana.KalameRoyal.domain.Package;
import com.Prana.KalameRoyal.domain.Word;
import com.Prana.KalameRoyal.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PackageServiceImp implements PackageService {

    @Autowired
    private PackageRepository repository;


    @Override
    public Package createPackage(Package pack) {
        String[] letters = pack.getName().split("-");
        Package savedPackage = repository.save(pack);

        List<Word> threeLetterWords = new ArrayList<>();
        for ( int i=0 ; i<6 ; i++ ){
            for ( int j=0 ; j<6 ; j++ ){
                if ( j != i ) {
                    for (int k = 0; k < 6; k++) {
                        if ( k != j && k != i ){
                            String word = letters[i]+letters[j]+letters[k];
                            Word createdWord = new Word();
                            createdWord.setWord(word);
                            createdWord.setPackageId(savedPackage.getId());
                            threeLetterWords.add(createdWord);
                        }
                    }
                }
            }
        }
        removeDuplicates(threeLetterWords);
        setWordsIds(threeLetterWords);
        savedPackage.setThreeLetterWords(threeLetterWords);

        List<Word> fourLetterWords = new ArrayList<>();
        for ( int i=0 ; i<6 ; i++ ){
            for ( int j=0 ; j<6 ; j++ ){
                if ( j != i ) {
                    for (int k = 0; k < 6; k++) {
                        if ( k != j && k != i ){
                            for ( int m=0 ; m<6 ; m++ ){
                                if ( m != i && m != j && m != k){
                                    String word = letters[i]+letters[j]+letters[k]+letters[m];
                                    Word createdWord = new Word();
                                    createdWord.setWord(word);
                                    createdWord.setPackageId(savedPackage.getId());
                                    fourLetterWords.add(createdWord);
                                }
                            }
                        }
                    }
                }
            }
        }
        removeDuplicates(fourLetterWords);
        setWordsIds(fourLetterWords);
        savedPackage.setFourLetterWords(fourLetterWords);

        List<Word> fiveLetterWords = new ArrayList<>();
        for ( int i=0 ; i<6 ; i++ ){
            for ( int j=0 ; j<6 ; j++ ){
                if ( j != i ) {
                    for (int k = 0; k < 6; k++) {
                        if ( k != j && k != i ){
                            for ( int m=0 ; m<6 ; m++ ){
                                if ( m != i && m != j && m != k){
                                    for ( int n=0 ; n<6 ; n++ ){
                                        if ( n != i && n != j && n != k && n != m ){
                                            String word = letters[i]+letters[j]+letters[k]+letters[m]+letters[n];
                                            Word createdWord = new Word();
                                            createdWord.setWord(word);
                                            createdWord.setPackageId(savedPackage.getId());
                                            fiveLetterWords.add(createdWord);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        removeDuplicates(fiveLetterWords);
        setWordsIds(fiveLetterWords);
        savedPackage.setFiveLetterWords(fiveLetterWords);

        return repository.save(pack);
    }

    @Override
    public List<Package> getAllPackages() {
        return repository.findIdAndNameAndAndCompleted();
    }

    @Override
    public Package findById(String id) {
        return repository.findById(id).get();
    }

    public static List<Word> removeDuplicates(List<Word> list){
        List<String> wordsToString = new ArrayList<>();
        for (Word word : list) {
            wordsToString.add(word.getWord());
        }
        List<String> nonDuplicatedStringList = new ArrayList<>();
        for (String s : wordsToString) {
            if ( !nonDuplicatedStringList.contains(s) ){
                nonDuplicatedStringList.add(s);
            }
        }
        List<Word> finalNonDuplicatedWordList = new ArrayList<>();
        for (String s : nonDuplicatedStringList) {
            Word finalWord = new Word();
            finalWord.setWord(s);
            finalNonDuplicatedWordList.add(finalWord);
        }
        return finalNonDuplicatedWordList;
    }

    public List<Word> setWordsIds(List<Word> list){
        for (Word word : list) {
            word.setId(UUID.randomUUID().toString());
        }
        return list;
    }

    @Override
    public Boolean hiddenWord(String packageId, String wordId, int tedadHoruf) {
        Package foundedPackage = repository.findById(packageId).get();
        if ( tedadHoruf == 3 ){
            for (Word threeLetterWord : foundedPackage.getThreeLetterWords()) {
                if ( threeLetterWord.getId().equalsIgnoreCase(wordId) ){
                    threeLetterWord.setHidden(true);
                    break;
                }
            }
        }
        if ( tedadHoruf == 4 ){
            for (Word fourLetterWord : foundedPackage.getFourLetterWords()) {
                if ( fourLetterWord.getId().equalsIgnoreCase(wordId) ){
                    fourLetterWord.setHidden(true);
                    break;
                }
            }
        }
        if ( tedadHoruf == 5 ){
            for (Word fiveLetterWord : foundedPackage.getFiveLetterWords()) {
                if ( fiveLetterWord.getId().equalsIgnoreCase(wordId) ){
                    fiveLetterWord.setHidden(true);
                    break;
                }
            }
        }
        repository.save(foundedPackage);
        return true;
    }

    @Override
    public Word editWord(String packageId, Word word) {
        Word edited = new Word();
        Package foundedPackage = repository.findById(packageId).get();
        if ( word.getWord().length() == 3 ){
            for (Word threeLetterWord : foundedPackage.getThreeLetterWords()) {
                if ( threeLetterWord.getId().equalsIgnoreCase(word.getId())){
                    threeLetterWord.setHidden(word.isHidden());
                    threeLetterWord.setScore(word.getScore());
                    threeLetterWord.setCategories(word.getCategories());
                    edited = threeLetterWord;
                    edited.setWord(word.getWord());
                    edited.setId(word.getId());
                }
            }
        }
        if ( word.getWord().length() == 4 ){
            for (Word fourLetterWord : foundedPackage.getFourLetterWords()) {
                if ( fourLetterWord.getId().equalsIgnoreCase(word.getId())){
                    fourLetterWord.setHidden(word.isHidden());
                    fourLetterWord.setScore(word.getScore());
                    fourLetterWord.setCategories(word.getCategories());
                    edited = fourLetterWord;
                    edited.setWord(word.getWord());
                    edited.setId(word.getId());
                }
            }
        }
        if ( word.getWord().length() == 5 ){
            for (Word fiveLetterWord : foundedPackage.getFiveLetterWords()) {
                if ( fiveLetterWord.getId().equalsIgnoreCase(word.getId())){
                    fiveLetterWord.setHidden(word.isHidden());
                    fiveLetterWord.setScore(word.getScore());
                    fiveLetterWord.setCategories(word.getCategories());
                    edited = fiveLetterWord;
                    edited.setWord(word.getWord());
                    edited.setId(word.getId());
                }
            }
        }
        repository.save(foundedPackage);
        return edited;
    }

    @Override
    public Package changePackageFinalState(String packageId) {
        Package founded = repository.findById(packageId).get();
        founded.setCompleted(!founded.isCompleted());
        return repository.save(founded);
    }

    @Override
    public Package update(Package pack) {
        return repository.save(pack);
    }
}
