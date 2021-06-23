package service;

import model.File;
import repository.hibernate.FileRepositoryImpl;
import java.util.List;

public class FileService {

    private FileRepositoryImpl fileRepository = new FileRepositoryImpl();

    private String infDelete;

    public String getInfDelete() {
        return infDelete;
    }

    public File checkSaveService(String path, String metaData) {
        File file = new File(path,metaData);
        return fileRepository.save(file);
    }

    public File checkGetByIdService(Long id) {
        File file = fileRepository.getById(id);
        if (file != null) {
            return file;
        }else {
            return null;
        }
    }

    public List<File> checkGetAllService(){
        List<File> files = fileRepository.getAll();
        if(files != null){
            return files;
        }else {
            return null;
        }
    }

    public File checkUpdateService(Long id,String path, String metaData) {
        File file = new File(path,metaData);
        file.setId(id);
        File fileUpdate = fileRepository.update(file);
        if (fileUpdate != null) {
            return fileUpdate;
        }else{
            return null;
        }
    }

    public void checkDeleteByIdService(Long id) {
        File file = fileRepository.getById(id);
        if (file != null) {
            fileRepository.deleteById(id);
            infDelete = "User whith id = " + id + " is delete";
        } else {
            infDelete = "User whith id = " + id + " is not exist";
        }
    }
}
