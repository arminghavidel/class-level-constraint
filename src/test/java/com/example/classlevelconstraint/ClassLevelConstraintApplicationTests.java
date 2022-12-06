package com.example.classlevelconstraint;

import com.example.classlevelconstraint.controller.VaultController;
import com.example.classlevelconstraint.controller.dto.BudgetStructureRequestModel;
import com.example.classlevelconstraint.controller.dto.CreateVaultRequest;
import com.example.classlevelconstraint.controller.dto.SigningNodesRequestModel;
import com.example.classlevelconstraint.controller.dto.UserRequestModel;
import com.example.classlevelconstraint.infrastructure.exception.InvalidRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VaultController.class)
class ClassLevelConstraintApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createVault_withCorrectInfo_returnsCreated() throws Exception {
        var firstUser = new UserRequestModel("user1@user.com", 1, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 1, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(1));
    }

    @Test
    void createVault_withInvalidList_returnsBadRequest() throws Exception {
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, new ArrayList<>());

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("List should be non-empty!", optionalException.get().getMessage());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   "})
    void createVault_withInvalidName_returnsBadRequest(String name) throws Exception {
        var firstUser = new UserRequestModel("user1@user.com", 1, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 1, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, name, "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("Name should not be null or blank!", optionalException.get().getMessage());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   ", "user1user.com"})
    void createVault_withInvalidEmail_returnsBadRequest(String email) throws Exception {
        var firstUser = new UserRequestModel(email, 1, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 1, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("Email format should be valid!", optionalException.get().getMessage());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {0, -1})
    void createVault_withInvalidDecisionWeight_returnsBadRequest(Integer decisionWight) throws Exception {
        var firstUser = new UserRequestModel("user1@user.com", decisionWight, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 1, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("Decision weight should be positive and non-zero!", optionalException.get().getMessage());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {0, -1})
    void createVault_withInvalidRequiredSignatureNumber_returnsBadRequest(Integer requiredSignatureNumber) throws Exception {
        var firstUser = new UserRequestModel("user1@user.com", 1, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", requiredSignatureNumber, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("required signature number should be positive and non-zero!", optionalException.get().getMessage());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {0, -1})
    void createVault_withInvalidTotalSignatureNumber_returnsBadRequest(Integer totalSignatureNumber) throws Exception {
        var firstUser = new UserRequestModel("user1@user.com", 1, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 1, totalSignatureNumber, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("total signature number should be positive and non-zero!", optionalException.get().getMessage());
    }

    @Test
    void createVault_withRequiredSignatureNumberGreaterThanTotalSignatureNumber_returnsBadRequest() throws Exception{
        var firstUser = new UserRequestModel("user1@user.com", 1, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 4, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("The requiredSignatureNumber property should be less than or equal to totalSignatureNumber property!", optionalException.get().getMessage());
    }

    @Test
    void createVault_withInvalidDecisionWeightSum_returnsBadRequest() throws Exception{
        var firstUser = new UserRequestModel("user1@user.com", 2, false);
        var secondUser = new UserRequestModel("user2@user.com", 2, false);
        var signingNode = new SigningNodesRequestModel(null, "sn1", "sn1 description", 2, 3, List.of(firstUser, secondUser));
        var budgetStructure = new BudgetStructureRequestModel(null, "bs1", false, "bs1 description", List.of(signingNode));
        var request = new CreateVaultRequest(1, "vault1", "vault1 description", false, List.of(budgetStructure));

        MvcResult result = mvc.perform(
                        post("/vaults")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        Optional<InvalidRequestException> optionalException = Optional.ofNullable((InvalidRequestException) result.getResolvedException());
        assertFalse(optionalException.isEmpty());
        assertEquals("Sum of all decisionWeight property of users should be equal to totalSignatureNumber property!", optionalException.get().getMessage());
    }
}
