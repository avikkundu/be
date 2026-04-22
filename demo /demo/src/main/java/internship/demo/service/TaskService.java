package internship.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import internship.demo.model.Task;
import internship.demo.repo.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
public class TaskService {

	@Autowired
    private  TaskRepository repo;


    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task create(Task task) {
        return repo.save(task);
    }

    public Task update(String id, Task task) {
        task.setId(id);
        return repo.save(task);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
