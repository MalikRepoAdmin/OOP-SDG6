package entity;

import database.impl.DatabaseMock;
import entity.impl.NewComment;
import entity.impl.OldComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CommentTest {

    @BeforeEach
    public void resetStaticCommentState() throws Exception {
        Field commentCountField = AbstractComment.class.getDeclaredField("commentCount");
        commentCountField.setAccessible(true);
        commentCountField.setInt(null, 0);
    }

    @Test
    public void testNewCommentAddCommentAndSend() {
        DatabaseMock database = new DatabaseMock();
        NewComment newComment = new NewComment(database);

        newComment.addComment("Halo dari unit test", "7");
        assertEquals(1, newComment.getCommentId());
        assertEquals(1, newComment.getCommentID());

        newComment.sendComment();

        Map<String, Object> commentData = database.getOneComment("0");
        assertNotNull(commentData, "Comment row should exist after sendComment");
        assertEquals("7", commentData.get("id_user"));
        assertEquals("Halo dari unit test", commentData.get("isi_komentar"));
        assertNotNull(commentData.get("tgl_dibuat"));
        assertNull(commentData.get("tgl_modified"));
    }

    @Test
    public void testOldCommentUpdateCommentAndSend() {
        DatabaseMock database = new DatabaseMock();
        LocalDate createdDate = LocalDate.of(2026, 1, 1);
        database.createTo_komentar("3", "Komentar lama", createdDate);

        OldComment oldComment = new OldComment(database, "0");
        assertEquals(0, oldComment.getCommentId());
        assertEquals(0, oldComment.getCommentID());

        oldComment.updateComment("Komentar baru");
        oldComment.sendComment();

        Map<String, Object> commentData = database.getOneComment("0");
        assertEquals("Komentar baru", commentData.get("isi_komentar"));
        assertNotNull(commentData.get("tgl_modified"));
    }
}
