package qna.domain.entity;

import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
public class Answers {

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @Where(clause = "deleted = false")
    @OrderBy("id ASC")
    List<Answer> values = new ArrayList<>();

    public void delete(User loginUser) {
         this.values.stream()
                .forEach(answer -> answer.delete(loginUser));
    }

    public List<DeleteHistory> makeHistory(User loginUser){
        return this.values.stream()
                .map(answer -> answer.makeHistory(loginUser))
                .collect(Collectors.toUnmodifiableList());
    }


    public void add(Answer answer) {
        this.values.add(answer);
    }
}
