package com.example.identityservice.controller;

import com.example.identityservice.dto.request.ApiResponse;
import com.example.identityservice.dto.request.PermissionRequest;
import com.example.identityservice.dto.response.PermissionResponse;
import com.example.identityservice.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@Slf4j
public class PermissionController {
        private final PermissionService permissionService;
        @PostMapping("/add")
        public ApiResponse<PermissionResponse> create( @RequestBody PermissionRequest request){

            return ApiResponse.<PermissionResponse>builder()
                    .result(permissionService.create(request))
                    .build();
        }

        @GetMapping("/list")
        public ApiResponse<List<PermissionResponse>> getALL(){
            return ApiResponse.<List<PermissionResponse>>builder()
                    .result(permissionService.getAll())
                    .build();
        }

        @DeleteMapping("/delete/{id}")
        public ApiResponse<Void> delete(@PathVariable String id){
            permissionService.delete(id);
            return ApiResponse.<Void>builder().build();
        }
}
