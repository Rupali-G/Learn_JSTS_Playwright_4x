Objective:

Generate the Selenium Production Ready Framework for the [salesforce.com](https://login.salesforce.com/?locale=in) in the Java with Testng, maven.

********************************************************************
Q1. What is your propmt if you use "02_RICE_POT_Prompt.md" :
ANS: 
1. Drag and drop "Selenium_Framework" folder and your "02_RICE_POT_Prompt.md" file in chat
2. Give command => We want you to create selenium framework by using "Selenium_Framework" folder and use template "02_RICE_POT_Prompt.md". I want you to read this "02_RICE_POT_Prompt.md" file and follow all instruction. Note in this machine I am using java version 17

Q2. If you want to create genric .md file prompt for that=>
ANS: 
Please create this as Genric RICE POT template so that we can use this template for the QA task, Test plan or test case also and give me md file and add provide "02_RICE_POT_Prompt.md" file here

Q3. Use Genric command "04_RICE_POT_Generic_QA_Template.md":
1. Drag and drop "Selenium_Framework" folder and your "04_RICE_POT_Generic_QA_Template.md" file in chat
2. Give command => We want you to create selenium framework in "Selenium_Framework" folder and use tempate "04_RICE_POT_Generic_QA_Template.md". I want you to ask me the question related to it and then create a proper selenium framework for it.

Q4. Task => We want to Create test plan in "Test Plan" folder and use genric tempate "04_RICE_POT_Generic_QA_Template.md" and "Product Requirements Document (PRD) VWO.com.pdf". I want you to ask me the question related to it and then we will create a proper test plan for it.

Q5. Question it will ask while using genric template
QA_ROLE = QA Automation Tester
EXPERIENCE = 15+ years
DOMAIN = Digital Experience Optimization (DXO)
SPECIALIZATION = Software Testing / QA / Test Planning
TASK_TYPE = Test Plan Generation
APPLICATION_NAME = VWO.com
TASK_OBJECTIVE = Analyze the provided requirements for VWO.com and generate a comprehensive enterprise-level Test Plan that defines the testing scope, strategy, test types, test scenarios, test coverage, risks, dependencies, test environment, entry/exit criteria, and Requirement Traceability Matrix (RTM).
TASK_SPECIFIC_INSTRUCTIONS = refer folder "D:\Rupali\TestingAcademy"

Application or system: {{APPLICATION_NAME}} = VWO (Visual Website Optimizer)
Feature or module: {{FEATURE_NAME}} = VWO Experimentation Platform – A/B Testing, Visual Editor, Campaign Creation, Targeting, Goals, Variations, Reports and Analytics
Business domain: {{DOMAIN}} = MarTech (Marketing Technology) / Digital Experience Optimization (DXO) / Conversion Rate Optimization (CRO)
Environment and URL: {{ENVIRONMENT_AND_URL}} =production,  https://vwo.com/
Users and roles: {{USER_ROLES}} = VWO Account Admin, Account Owner, Project Manager, Marketer, Experiment Creator, Developer, Analyst, and other users based on assigned permissions

Requirements and acceptance criteria:{{REQUIREMENTS_AND_ACCEPTANCE_CRITERIA}}
= Use the provided VWO Product Requirements Document (PRD) and available business requirements as the source of truth. Derive test scenarios and expected results from the documented functional requirements and acceptance criteria. Do not invent requirements that are not documented.

Available inputs, documents, screenshots, or source excerpts:
{{SOURCE_MATERIAL}}
= Attached VWO.com Product Requirements Document (PRD), including functional requirements, business requirements, feature descriptions, workflows, screenshots, and acceptance criteria wherever available.

Available test data and account prerequisites:
{{TEST_DATA_AND_PREREQUISITES}}
= Valid VWO test account with appropriate user roles and permissions. Test projects, campaigns, audiences, goals, variations, and sample data as required by the documented requirements. Test data should include valid, invalid, boundary, and negative data wherever applicable.

Known limitations, dependencies, and missing information:
{{KNOWN_GAPS_AND_DEPENDENCIES}}
= Testing scope and coverage are limited to the requirements and information available in the provided PRD and source materials. Any functionality, business rule, integration, user role, environment configuration, browser/device support, API behavior, or acceptance criteria not documented in the source material should be identified as an assumption or open question rather than invented. External integrations and third-party services may require separate environments, credentials, or test data.

Use this example to understand the expected structure and detail:
{{REFERENCE_EXAMPLE}}
= Use this example to understand the expected structure and detail:
Example Test Scenario:
Module: Login
Scenario ID: TS-LOGIN-001
Scenario: Verify that a registered user can log in with valid credentials.
Preconditions:
- User has a valid registered account.
- Login page is accessible.
- User account is active.

Test Data:
- Valid username/email
- Valid password

Steps:
1. Navigate to the login page.
2. Enter a valid username/email.
3. Enter a valid password.
4. Click the Login button.

Expected Result:
- User should be successfully authenticated.
- User should be redirected to the application dashboard.
- No error message should be displayed.

Priority: High
Test Type: Functional / Positive

The generated VWO Test Plan should follow a similar level of structure, clarity, and detail. Use VWO-specific modules, requirements, workflows, and business rules from the provided PRD. Do not copy the example's application-specific content

Task type: {{TASK_TYPE}} = Test Plan Generation
In scope: {{IN_SCOPE}}
= Functional testing of VWO.com based on the provided PRD, including core features and workflows, UI testing, positive and negative testing, validation testing, boundary and edge-case testing, end-to-end business flows, role and permission testing, integration testing, API testing where applicable, regression testing, compatibility testing, usability testing, accessibility testing, security testing, and performance testing where supported by the requirements.

Out of scope: {{OUT_OF_SCOPE}}
= Features, integrations, business rules, APIs, user roles, platforms, or workflows that are not documented in the provided PRD or source material. Production testing, third-party systems that cannot be accessed, and performance/security testing requiring specialized infrastructure should be identified as out of scope unless explicitly required.

Required coverage: {{COVERAGE}}
= Ensure all documented requirements and acceptance criteria are covered by test scenarios. Include positive, negative, boundary, validation, error-handling, integration, role/permission, security, usability, compatibility, regression, and end-to-end scenarios wherever applicable. Provide Requirement Traceability Matrix (RTM) to demonstrate requirement coverage.

Exact counts or size limits: {{COUNTS_AND_LIMITS}}
= No fixed number of test scenarios. Generate as many scenarios as required to achieve complete requirement coverage. Avoid unnecessary duplicate scenarios. Prioritize critical business flows and high-risk functionality.

Tools, language, framework, and versions: {{TECHNOLOGY_STACK}}
= Test Plan should be tool and framework independent. Use professional QA terminology. Automation recommendations may include Selenium with Java, Playwright with Java/TypeScript, API automation, and other appropriate tools, but do not generate automation scripts.

Browsers, devices, operating systems, or execution targets: {{TARGET_PLATFORMS}}
= Cover supported browsers and platforms documented in the PRD. Where browser/device support is not specified, identify it as a requirement gap rather than assuming a specific configuration. Recommended web targets may include Chrome, Firefox, Edge, and Safari across supported desktop and mobile environments.

Quality or acceptance thresholds: {{QUALITY_CRITERIA}}
= 100% coverage of documented requirements and acceptance criteria. All Critical and High-priority business flows must have corresponding test scenarios. No Critical/Blocker defects should remain open for release sign-off unless explicitly accepted by stakeholders. Test execution should satisfy the defined Entry and Exit Criteria.

Mandatory practices: {{MANDATORY_PRACTICES}}
= 
1. Use the provided VWO PRD as the single source of truth.
2. Map requirements to test scenarios using an RTM.
3. Include positive, negative, boundary, and edge-case scenarios.
4. Cover critical end-to-end business workflows.
5. Include risk-based testing.
6. Identify assumptions, dependencies, gaps, and open questions.
7. Prioritize scenarios as Critical, High, Medium, or Low.
8. Include functional and relevant non-functional testing.
9. Avoid duplicate test scenarios.
10. Clearly distinguish documented requirements from assumptions.

Prohibited practices: {{PROHIBITED_PRACTICES}}
= 
1. Do not invent requirements or business rules.
2. Do not assume unsupported features or workflows.
3. Do not create duplicate test scenarios.
4. Do not generate automation scripts as part of the Test Plan.
5. Do not claim 100% coverage if requirements are missing or ambiguous.
6. Do not assume browsers, devices, APIs, integrations, or user roles that are not documented.
7. Do not omit negative, boundary, security, permission, or error-handling scenarios when applicable.

Deliverables: {{DELIVERABLES}}
= Deliverables:
1. Complete Enterprise-Level Test Plan
2. Test Scope – In Scope and Out of Scope
3. Test Strategy and Testing Approach
4. Test Types and Test Coverage
5. Module-wise Test Scenarios
6. Positive, Negative, Boundary, and Edge-Case Scenarios
7. End-to-End Business Flow Scenarios
8. Test Environment and Test Data Requirements
9. Entry and Exit Criteria
10. Roles and Responsibilities
11. Defect Management Strategy
12. Risks, Dependencies, Assumptions, and Mitigation
13. Test Metrics and Reporting
14. Requirement Traceability Matrix (RTM)
15. Test Coverage Summary
16. Automation Testing Recommendations
17. Open Questions and Missing Requirements

Format: {{OUTPUT_FORMAT}} = Professional enterprise QA Test Plan in Markdown format with clear headings, tables, numbered sections, and structured test scenarios.

Required structure or fields:{{OUTPUT_SCHEMA}}
=
1. Test Plan Overview
2. Objectives
3. Application Overview
4. Business Domain
5. Scope
   - In Scope
   - Out of Scope
6. Features/Modules Under Test
7. Testing Strategy
8. Testing Types
9. Test Scenarios
   - Scenario ID
   - Module/Feature
   - Scenario Description
   - Preconditions
   - Test Data
   - Test Type
   - Priority
   - Expected Result
10. End-to-End Scenarios
11. Test Environment
12. Test Data Requirements
13. User Roles and Permissions
14. Entry Criteria
15. Exit Criteria
16. Defect Management
17. Risks and Mitigation
18. Dependencies
19. Assumptions
20. Test Deliverables
21. Test Metrics
22. Regression Strategy
23. Automation Recommendations
24. Requirement Traceability Matrix (RTM)
   - Requirement ID
   - Requirement Description
   - Test Scenario ID
   - Coverage
25. Open Questions / Missing Information
26. Final Test Coverage Summary

Final explanation level: {{FINAL_EXPLANATION_LEVEL}}
= Detailed but easy to understand. Use simple, professional QA terminology. Provide enough detail for QA engineers, developers, business analysts, project managers, and stakeholders to understand the testing approach. Avoid unnecessary technical jargon. Clearly identify assumptions and missing information instead of inventing requirements.


