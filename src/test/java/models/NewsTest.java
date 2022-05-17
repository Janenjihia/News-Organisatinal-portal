package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    public  News setUpNews(){
        News testNews = new News("UEFA Finals", "Liverpool vs Real Madrid", 1);
        return testNews;
    }

    @Test
    void getTitle() {
        News testNews = setUpNews();
        assertEquals("UEFA Finals", testNews.getTitle());
    }

    @Test
    void getContent() {
        News testNews = setUpNews();
        assertEquals("Liverpool vs Real Madrid", testNews.getContent());
    }


    @Test
    void getDepartmentId() {
        News testNews = setUpNews();
        assertEquals(1, testNews.getDepartmentId());
    }


    @Test
    void testEquals() {
        News testNews = setUpNews();
        News testNews2 = setUpNews();
        assertTrue(testNews.equals(testNews2));
    }
}