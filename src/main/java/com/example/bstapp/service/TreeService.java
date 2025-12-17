package com.example.bstapp.service;

import com.example.bstapp.model.TreeResult;
import com.example.bstapp.repo.TreeResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.bstapp.service.TreeDtos.TreeNode;
import static com.example.bstapp.service.TreeDtos.TreeResponse;

@Service
public class TreeService {

    private final TreeResultRepository repo;
    private final ObjectMapper mapper;
    private final BstService bst;

    public TreeService(TreeResultRepository repo) {
        this.repo = repo;
        this.mapper = new ObjectMapper();
        this.bst = new BstService();
    }

    public TreeResponse process(String input, boolean balanced) throws Exception {
        List<Integer> nums = parseNumbers(input);

        TreeNode root = balanced
                ? bst.buildBalanced(nums)       // bonus
                : bst.buildSequential(nums);    // required

        TreeResponse response = new TreeResponse(root);

        String json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(response);

        repo.save(new TreeResult(input, json, LocalDateTime.now()));
        return response;
    }

    private List<Integer> parseNumbers(String input) {
        if (input == null) return List.of();

        String trimmed = input.trim();
        if (trimmed.isEmpty()) return List.of();

        String[] parts = trimmed.split("[,\\s]+");
        List<Integer> nums = new ArrayList<>();

        for (String p : parts) {
            if (p == null || p.isBlank()) continue;
            nums.add(Integer.parseInt(p.trim()));
        }
        return nums;
    }
}
