package service;

import model.File;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.hibernate.FileRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

class FileServiceTest {

    @Mock
    private FileRepositoryImpl fileRepository = Mockito.mock(FileRepositoryImpl.class);
    @Mock
    private FileService fileService = Mockito.mock(FileService.class);

    @Test
    void chekGetInfDelete_Should_Run_getInfDelete() {
        fileService.getInfDelete();
        Mockito.verify(fileService).getInfDelete();
    }

    @Test
    void checkSaveService_Should_Return_File() {
        File file = new File("Igor","Golin");
        when(fileRepository.save(file)).thenReturn(file);
    }

    @Test
    void checkGetByIdService_Should_Return_File_By_Id() {
        File file = new File("Igor","Golin");
        when(fileRepository.getById(2L)).thenReturn(file);
    }

    @Test
    void checkGetAllService_Should_Show_All_of_Files() {
        List<File> fileList = new ArrayList<>();
        when(fileRepository.getAll()).thenReturn(fileList);
    }

    @Test
    void checkUpdateService_Should_Return_UpdateFile() {
        File file = new File("Igor","Golin");
        when(fileRepository.update(file)).thenReturn(file);
    }

    @Test
    void checkDeleteByIdService() {
        fileService.checkDeleteByIdService(2L);
        Mockito.verify(fileService).checkDeleteByIdService(2L);
    }
}