package view;

import model.ModelException;
import model.dao.DAOFactory;
import model.dao.PostDAO;
import model.entities.Post;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PostDAO postDAO = (PostDAO) DAOFactory.getDAO(PostDAO.class);

        Post newPost = new Post();
        newPost.setContent("Este é um post de teste.");
        newPost.setDate(new Date());

        try {
            // Salvar novo post
            postDAO.save(newPost);

            // Listar todos os posts
            for (Post post : postDAO.listAll()) {
                System.out.println("ID: " + post.getId());
                System.out.println("Content: " + post.getContent());
                System.out.println("Date: " + post.getDate());
                System.out.println();
            }
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }
}
