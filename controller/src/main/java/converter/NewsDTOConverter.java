package converter;

import dto.NewsDTO;
import dto.NewsTitleDTO;
import newsController.News;

import java.util.List;
import java.util.stream.Collectors;

public class NewsDTOConverter {
    public static NewsDTO createNewsDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setDate(news.getDate());
        newsDTO.setName(news.getName());
        newsDTO.setContent(news.getContent());
        newsDTO.setAuthor(news.getAuthor());
        newsDTO.setCategoryName(news.getCategoryName());

        return newsDTO;
    }

    public static News createNewsBO(NewsDTO newsDTO) {
        News news = new News();
        news.setId(newsDTO.getId());
        news.setDate(newsDTO.getDate());
        news.setName(newsDTO.getName());
        news.setContent(newsDTO.getContent());
        news.setAuthor(newsDTO.getAuthor());
        news.setCategoryName(newsDTO.getCategoryName());

        return news;
    }

    public static List<NewsDTO> createNewsDTOList(List<News> newsBOList) {
        return newsBOList.stream().map(NewsDTOConverter::createNewsDTO).collect(Collectors.toList());
    }

    public static List<News> createNewsBOList(List<NewsDTO> newsDTOList) {
        return newsDTOList.stream().map(NewsDTOConverter::createNewsBO).collect(Collectors.toList());
    }

    public static NewsTitleDTO createNewsTitleDTO(News newsBO) {
        NewsTitleDTO newsTitleDTO = new NewsTitleDTO();
        newsTitleDTO.setTitle(newsBO.getName());

        return newsTitleDTO;
    }

    public static List<NewsTitleDTO> createNewsTitleDTOList(List<News> newsBOList) {
        return newsBOList.stream().map(NewsDTOConverter::createNewsTitleDTO).collect(Collectors.toList());
    }
}
