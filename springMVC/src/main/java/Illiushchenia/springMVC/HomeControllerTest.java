package Illiushchenia.springMVC;

import static Illiushchenia.springMVC.HomeController.*;
import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
/**
 * Created by USER on 13.11.2016.
 */
public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles =
                asList(new Spittle(), new Spittle(), new Spittle());
        // Фиктивный объект SpitterService
        SpitterService spitterService = mock(SpitterService.class);
        when(spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE)).
                thenReturn(expectedSpittles);

        // Создать контроллер
        HomeController controller =
                new HomeController(spitterService);

        HashMap<String, Object> model = new HashMap<String, Object>();

        // Вызвать обработчик
        String viewName = controller.showHomePage(model);

        assertEquals("home", viewName);

        // Проверить результаты

        assertSame(expectedSpittles, model.get("spittles"));

        verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
    }
}
