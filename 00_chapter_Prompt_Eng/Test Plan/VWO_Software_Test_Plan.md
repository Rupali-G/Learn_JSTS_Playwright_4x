# SOFTWARE TEST PLAN

**VWO – Digital Experience Optimization Platform**

Experimentation · Insights · Personalization · Integrations · Collaboration

| Field | Value |
| --- | --- |
| Test Plan ID | TP-VWO-001 |
| Version / Status | 1.0 / Draft for review |
| Date | 07 October 2026 |
| Product under test | VWO – https://vwo.com/ (entry) and https://app.vwo.com/ (application) |
| Product version / build | Not provided [TBC] |
| Source requirements | Product Requirements Document (PRD) VWO.com, prepared by Pramod Dutta, dated 07 January 2026 |
| Prepared by | QA Lead – name to be entered |
| Approvers | Product Manager, Engineering Manager, QA Lead (see Section 12) |

**Document Control**

| Version | Date | Author | Change summary |
| --- | --- | --- | --- |
| 0.1 | 07-Oct-2026 | QA Lead | Initial draft from PRD and stakeholder clarification session |
| 1.0 | 07-Oct-2026 | QA Lead | Draft issued for review and approval |

**Source Labels Used in This Plan**

Every statement that is not a direct restatement of the PRD carries a label so reviewers can separate facts from proposals:

| Label | Meaning |
| --- | --- |
| [PRD] | Stated in the PRD dated 07 January 2026. |
| [Stakeholder] | Confirmed by the stakeholder during the planning clarification session (07 October 2026). |
| [Proposed] | Recommended by QA; requires agreement before it becomes binding. |
| [Assumption] | Taken as true for planning; must be validated. Listed in Section 10.3. |
| [TBC] | To be confirmed; information not provided. Tracked as an open question in Section 10.4. |

Requirement IDs FR1–FR9 come from the PRD. All other requirement, scenario, risk and question IDs (for example NFR-PERF-01, TS-FR1-01, R-01) are **locally assigned** by QA for traceability.

## Table of Contents

- [1. Test Plan ID and Title](#1-test-plan-id-and-title)
- [2. Objective and References](#2-objective-and-references)
  - [2.1 Purpose](#21-purpose)
  - [2.2 Test Objectives](#22-test-objectives)
  - [2.3 Business Context](#23-business-context)
  - [2.4 References](#24-references)
- [3. In Scope and Out of Scope](#3-in-scope-and-out-of-scope)
  - [3.1 In Scope](#31-in-scope)
  - [3.2 Out of Scope](#32-out-of-scope)
- [4. Requirements and Planned Coverage](#4-requirements-and-planned-coverage)
  - [4.1 Functional Requirements Coverage](#41-functional-requirements-coverage)
  - [4.2 Non-Functional Requirements Coverage](#42-non-functional-requirements-coverage)
  - [4.3 Coverage Summary](#43-coverage-summary)
- [5. Test Approach, Levels, and Types](#5-test-approach-levels-and-types)
  - [5.1 Overall Strategy](#51-overall-strategy)
  - [5.2 Test Levels](#52-test-levels)
  - [5.3 Test Types](#53-test-types)
  - [5.4 Automation Strategy](#54-automation-strategy)
  - [5.5 Production-Safety Rules](#55-production-safety-rules)
- [6. Environment, Tools, Access, and Test Data](#6-environment-tools-access-and-test-data)
  - [6.1 Test Environment](#61-test-environment)
  - [6.2 Browser, Device, and OS Matrix](#62-browser-device-and-os-matrix)
  - [6.3 Tools](#63-tools)
  - [6.4 Access and Accounts](#64-access-and-accounts)
  - [6.5 Role × Permission Matrix](#65-role-permission-matrix)
  - [6.6 Test Data](#66-test-data)
- [7. Entry and Exit Criteria](#7-entry-and-exit-criteria)
  - [7.1 Entry Criteria](#71-entry-criteria)
  - [7.2 Exit Criteria](#72-exit-criteria)
- [8. Roles, Responsibilities, Estimates, and Schedule](#8-roles-responsibilities-estimates-and-schedule)
  - [8.1 Team and Responsibilities](#81-team-and-responsibilities)
  - [8.2 RACI Matrix](#82-raci-matrix)
  - [8.3 Schedule](#83-schedule)
  - [8.4 Effort Estimate](#84-effort-estimate)
- [9. Defect Management and Reporting](#9-defect-management-and-reporting)
  - [9.1 Defect Lifecycle](#91-defect-lifecycle)
  - [9.2 Severity Definitions](#92-severity-definitions)
  - [9.3 Priority and Proposed Fix Targets](#93-priority-and-proposed-fix-targets)
  - [9.4 Defect Report Content](#94-defect-report-content)
  - [9.5 Triage](#95-triage)
  - [9.6 Reporting Cadence and Metrics](#96-reporting-cadence-and-metrics)
- [10. Risks, Dependencies, Assumptions, and Open Questions](#10-risks-dependencies-assumptions-and-open-questions)
  - [10.1 Risk Register](#101-risk-register)
  - [10.2 Dependencies](#102-dependencies)
  - [10.3 Assumptions](#103-assumptions)
  - [10.4 Open Questions](#104-open-questions)
- [11. Suspension and Resumption Criteria](#11-suspension-and-resumption-criteria)
  - [11.1 Suspension Criteria](#111-suspension-criteria)
  - [11.2 Resumption Criteria](#112-resumption-criteria)
- [12. Test Deliverables and Approval](#12-test-deliverables-and-approval)
  - [12.1 Test Deliverables](#121-test-deliverables)
  - [12.2 Approval](#122-approval)
- [Appendix A – Glossary](#appendix-a-glossary)
- [Appendix B – Test Type × Module Coverage Heat-map](#appendix-b-test-type-module-coverage-heat-map)

## 1. Test Plan ID and Title

| Attribute | Detail |
| --- | --- |
| Test Plan ID | TP-VWO-001 |
| Title | Software Test Plan – VWO Digital Experience Optimization (DXO) and Conversion Rate Optimization (CRO) Platform |
| Plan type | Master test plan covering functional, integration, regression and non-functional testing |
| Application | VWO (Visual Website Optimizer) [PRD] |
| Environment | Production – https://vwo.com/ and https://app.vwo.com/ [Stakeholder][PRD] |
| Product version / release | Not provided [TBC] – Q-01 |
| Test window | 12 October 2026 – 04 December 2026 (8 weeks) [Proposed] |

## 2. Objective and References

### 2.1 Purpose

This plan defines the scope, approach, resources, schedule, entry/exit criteria and governance for testing the VWO platform against the PRD. It is the single reference for QA, Product, Engineering and other stakeholders on what will be tested, how, by whom, and how release quality will be judged.

### 2.2 Test Objectives

1. Verify that functional requirements FR1–FR9 behave as described in the PRD (Section 6 of the PRD).
2. Validate the two end-to-end user flows: Setting Up an A/B Test (PRD 5.1) and Analyzing Behavioral Data (PRD 5.2).
3. Verify the non-functional requirements: editing-workflow response within 2 seconds, 2FA, role-based access control and activity logs, scalability, GDPR/CCPA compliance and the 99.9% uptime SLA (PRD Section 7).
4. Independently validate the accuracy of SmartStats Bayesian results, addressing the PRD risk "Data Accuracy Challenges" (PRD Section 10).
5. Verify access control for the stakeholder-defined roles: Account Admin, Account Owner, Project Manager, Marketer, Experiment Creator, Developer, Analyst and custom-permission users [Stakeholder].
6. Confirm compatibility across the agreed browser, device and operating-system matrix.
7. Provide objective evidence – metrics, defect status and residual risk – to support the release go/no-go decision.

### 2.3 Business Context

VWO serves CRO specialists, product managers, UX designers, digital marketers and analysts, with engineering teams and executives as secondary users [PRD]. Its business goals are to improve funnel conversion, enable evidence-based UX decisions, reduce engineering dependency and unify optimization insights [PRD]. Testing therefore prioritizes correctness of experiment delivery and statistical results, data privacy, and workflow usability for non-engineering users.

### 2.4 References

| Ref | Document | Version / Date | Status |
| --- | --- | --- | --- |
| REF-01 | Product Requirements Document (PRD) VWO.com – Pramod Dutta | 07 January 2026 | Reviewed – primary source |
| REF-02 | 04_RICE_POT_Generic_QA_Template.md – Profile B (Test Plan) | Current | Reviewed – plan structure |
| REF-03 | VWO official product pages and documentation (cited by the PRD) | Not provided | Not reviewed for this plan [TBC] |
| REF-04 | WCAG 2.1 – Web Content Accessibility Guidelines | W3C Recommendation | Accessibility benchmark [Proposed] |
| REF-05 | GDPR (EU 2016/679) and CCPA (California) | Current | Privacy compliance benchmark [PRD] |
| REF-06 | OWASP Top 10 and OWASP ASVS | Current | Security test benchmark [Proposed] |

## 3. In Scope and Out of Scope

### 3.1 In Scope

| Area | PRD ref. | Coverage summary |
| --- | --- | --- |
| Experimentation & Testing | FR1, FR2, FR3, FR5, FR6; 4.1; flow 5.1 | A/B, Split URL and Multivariate tests; variations; audience targeting; custom goals and metrics; SmartStats results; visual and code editors; version previews; scheduling; real-time reports and dashboards |
| Behavioral Insights | FR4; 4.2; flow 5.2 | Click, scroll and focus heatmaps; session recordings; on-page surveys and feedback; funnel analytics |
| Personalization | FR7; 4.3 | Segmentation by geography, behavior and demographics; real-time delivery of tailored content |
| Integrations | FR8; 4.1, 4.5 | Google Analytics, Mixpanel, Shopify, Salesforce, Segment, Snowflake, WordPress, Drupal, CDPs and analytics systems – VWO side of each connector |
| Program & Workflow Management | FR9; 4.4 | Central planning interface, collaboration tools, Kanban experiment backlog |
| Access & Security | NFR Security | 2FA, role-based access control for all stakeholder roles, activity logs, authentication and session handling |
| Non-functional | PRD Section 7 | Performance, scalability, data privacy, reliability; plus usability/accessibility and cross-browser compatibility [Stakeholder] |
| Statistical accuracy | FR2; PRD risk | Independent verification of SmartStats outputs against controlled datasets |

### 3.2 Out of Scope

| Item | Reason |
| --- | --- |
| Pricing, plan tiers, billing and payment flows (PRD Section 9) | Commercial area, not a functional requirement. Plan tier still determines feature availability – see Q-07. |
| Future enhancements: AI suggestion engine, native mobile SDK enhancements, predictive analytics / ROI forecasting (PRD Section 11) | Not yet delivered. |
| Internal behavior of third-party platforms (GA, Mixpanel, Shopify, Salesforce, Segment, Snowflake, WordPress, Drupal) | Owned by third parties. Only the VWO side of each integration and the data exchanged are tested. |
| Native mobile application experimentation | PRD lists mobile SDK work as a future enhancement. Mobile web is in scope. |
| Full penetration testing, red teaming and destructive security testing | Not permitted on production without a separate authorized engagement. Functional security tests and a passive baseline scan are in scope. |
| Unit and component testing of VWO source code | Development team responsibility. |
| Measurement of business KPIs (conversion uplift, NPS, experiment velocity – PRD Section 8) | Product success metrics, not release-quality criteria. |
| Failover / disaster-recovery execution on production infrastructure | Controlled by VWO SRE/DevOps. QA verifies observable availability only – see 5.3.7. |

## 4. Requirements and Planned Coverage

The tables below form the Requirements Traceability Matrix (RTM). Test scenario IDs are locally assigned and will be expanded into detailed test cases in the test-management tool during test design (Week 2). Test risk is a QA assessment [Proposed] combining business impact and failure likelihood.

### 4.1 Functional Requirements Coverage

| Req. ID | Feature | PRD priority | Planned test scenarios | Test types | Test risk |
| --- | --- | --- | --- | --- | --- |
| FR1 | A/B, Split & Multivariate Testing | Must | TS-FR1-01 Create A/B test with control and multiple variations<br>TS-FR1-02 Split URL test with distinct variation URLs<br>TS-FR1-03 Multivariate test – combination generation<br>TS-FR1-04 Traffic allocation and visitor assignment<br>TS-FR1-05 Lifecycle: draft, schedule, start, pause, stop<br>TS-FR1-06 Custom goals and metrics | Functional, Regression, Cross-browser, Statistical (SRM) | High |
| FR2 | SmartStats Engine | Must | TS-FR2-01 Bayesian results vs independent calculation<br>TS-FR2-02 A/A test produces no false winner<br>TS-FR2-03 Edge datasets: zero conversions, tiny samples, unequal traffic<br>TS-FR2-04 Winner conclusion and report consistency | Statistical accuracy, Functional, Regression | High |
| FR3 | Visual & Code Editor | Must | TS-FR3-01 WYSIWYG edits: text, image, style, hide/move element<br>TS-FR3-02 Code editor custom JS/CSS<br>TS-FR3-03 Version preview before launch<br>TS-FR3-04 Editor action response ≤ 2 s | Functional, Performance, Usability/A11y, Cross-browser | High |
| FR4 | Heatmaps & Session Recordings | Must | TS-FR4-01 Click, scroll and focus heatmap generation<br>TS-FR4-02 Session recording capture and playback<br>TS-FR4-03 Sensitive-field masking in recordings<br>TS-FR4-04 Surveys and funnel drop-off analytics | Functional, Privacy, Cross-browser, Performance | High |
| FR5 | Audience Targeting | High | TS-FR5-01 Behavior and attribute conditions<br>TS-FR5-02 AND/OR condition combinations (decision table)<br>TS-FR5-03 Inclusion/exclusion and non-matching visitors | Functional, Regression | High |
| FR6 | Real-time Reporting & Dashboards | Must | TS-FR6-01 Report data freshness vs agreed latency<br>TS-FR6-02 Dashboard totals vs generated traffic<br>TS-FR6-03 Filters, segments and export | Functional, Performance, Statistical | High |
| FR7 | Personalization Engine | High | TS-FR7-01 Segment by geography, behavior, demographics<br>TS-FR7-02 Real-time tailored content delivery<br>TS-FR7-03 Behavior when visitor also qualifies for a running test [TBC Q-05] | Functional, Integration, Privacy | Medium |
| FR8 | Integration Connectors | High | TS-FR8-01 Connect/disconnect each connector<br>TS-FR8-02 Data sync correctness (events, variation IDs)<br>TS-FR8-03 Invalid credentials, revoked access, sync failure handling | Integration, Security, Regression | Medium |
| FR9 | Collaboration & Workflow Management | Medium | TS-FR9-01 Create and prioritize backlog ideas<br>TS-FR9-02 Kanban state transitions<br>TS-FR9-03 Multi-user collaboration, comments, assignments | Functional, RBAC, Usability | Low |
| UF-5.1 | Flow: Setting Up an A/B Test | Must | TS-E2E-01 Hypothesis → audience → variations → launch → SmartStats → winner | End-to-end, Regression | High |
| UF-5.2 | Flow: Analyzing Behavioral Data | Must | TS-E2E-02 Insights dashboard → heatmaps/recordings/funnels → correlate with test → prioritize idea | End-to-end, Regression | High |

### 4.2 Non-Functional Requirements Coverage

| Local ID | Category | Requirement and source | Measurable check | Test type |
| --- | --- | --- | --- | --- |
| NFR-PERF-01 | Performance | System responds within 2 seconds for editing workflows [PRD] | p95 editor action response ≤ 2.0 s at agreed concurrency [Proposed] | Performance |
| NFR-SCAL-01 | Scalability | Support high visitor volumes without performance loss [PRD] | Target volume Not provided [TBC Q-04]; proposed baseline in 5.3.4 | Load / Scalability |
| NFR-SEC-01 | Security | 2FA [PRD] | Enrolment, login, recovery, enforcement by admin | Security |
| NFR-SEC-02 | Security | Role-based access control [PRD] | Allow/deny per role × permission matrix (Section 6.5) | Security, Functional |
| NFR-SEC-03 | Security | Activity logs [PRD] | Security-relevant actions logged with user, action, timestamp | Security |
| NFR-PRIV-01 | Data Privacy | GDPR, CCPA and regional data policies [PRD] | Consent, masking, opt-out, data deletion/export | Privacy & Compliance |
| NFR-REL-01 | Reliability | 99.9% uptime SLA for enterprise customers [PRD] | Synthetic availability monitoring; degradation behavior | Reliability |
| NFR-A11Y-01 | Accessibility | Not in PRD – added by stakeholder decision | WCAG 2.1 AA [Proposed] | Usability & Accessibility |
| NFR-COMP-01 | Compatibility | Cross-device / cross-browser (PRD 4.1 capability) | Agreed matrix, Section 6.2 [Stakeholder] | Cross-browser |

### 4.3 Coverage Summary

- 9 of 9 PRD functional requirements and both PRD user flows are mapped to at least one test scenario.
- 5 of 5 PRD non-functional categories are mapped; two stakeholder-added categories (accessibility, compatibility) are also mapped.
- Coverage here means **planned** coverage. No tests have been executed at the time of this plan.

## 5. Test Approach, Levels, and Types

### 5.1 Overall Strategy

Testing is **risk-based and requirement-driven**. Must-priority PRD features (FR1, FR2, FR3, FR4, FR6) and the two user flows receive the deepest coverage and are tested first in each cycle. Because the only environment is **production** [Stakeholder], every activity follows the production-safety rules in 5.5.

### 5.2 Test Levels

| Level | Scope | Owner |
| --- | --- | --- |
| Integration testing | VWO ↔ third-party connectors (FR8); VWO tracking code ↔ QA test website | QA Engineers |
| System testing | All FR1–FR9 features and NFRs in the VWO application | QA Engineers, Perf/Sec Engineer |
| End-to-end testing | PRD flows 5.1 and 5.2 across app, test website, reports and integrations | QA Engineers, Automation Engineer |
| Regression testing | Automated and manual suites after each VWO release in the window | Automation Engineer |
| User acceptance support | Support Product/business users executing acceptance scenarios | QA Lead |
| Unit / component testing | Out of scope – development responsibility | Development |

### 5.3 Test Types

| Test type | Objective | Techniques and approach |
| --- | --- | --- |
| Functional | Verify FR1–FR9 and user flows against PRD and agreed acceptance criteria | Equivalence partitioning, boundary values, decision tables (targeting rules), state transition (experiment lifecycle), pairwise (MVT combinations) |
| Integration | Verify data exchange between VWO and each connector | Sandbox accounts per platform; compare events and variation identifiers on both sides |
| Regression | Protect existing behavior across VWO releases | Risk-based suite; automated smoke on every release, full regression per cycle |
| Performance & Scalability | Validate NFR-PERF-01 and NFR-SCAL-01 | Browser-timed editor actions; load on QA-owned test website only with written approval |
| Security | Validate 2FA, RBAC, activity logs and common web risks | Role matrix tests, session tests, OWASP Top 10 checks, passive baseline scan |
| Data Privacy & Compliance | Validate GDPR/CCPA behavior | Consent, masking, opt-out, deletion/export request verification |
| Reliability | Observe availability and degradation behavior | Synthetic monitors, script-unavailable behavior on test website |
| Usability & Accessibility | Ease of use for non-engineers; WCAG 2.1 AA | Heuristic review, axe/Lighthouse scans, keyboard and screen-reader checks |
| Cross-browser / Cross-device | Consistent behavior on agreed matrix | Pairwise browser/OS/viewport selection; BrowserStack |
| Statistical accuracy | Independent validation of SmartStats | Golden datasets, A/A tests, independent Bayesian computation, sample ratio mismatch checks |

#### 5.3.1 Functional Testing

- Experiment lifecycle modeled as a state-transition diagram; exact state names to be confirmed from the application [TBC].
- Targeting rules (FR5) and personalization segments (FR7) covered with decision tables for AND/OR, include/exclude and non-matching visitors.
- Multivariate combinations selected with pairwise techniques; full combination checks for small designs.
- Expected results taken from the PRD, VWO documentation once reviewed (REF-03), or agreed acceptance criteria. No undocumented error text is assumed.

#### 5.3.2 Integration Testing

- One dedicated sandbox per connector: GA4 property, Mixpanel project, Shopify development store, Salesforce developer org, Segment workspace, Snowflake trial, WordPress and Drupal test sites [Proposed].
- For each connector: connect, sync, verify event/variation data on the receiving side, revoke credentials, verify failure handling and reconnection.

#### 5.3.3 Regression Testing

- Smoke suite (approx. 30 critical checks) runs after every VWO release and before each test day [Proposed].
- Full regression at the end of each execution cycle; suite maintained in the test-management tool with automation status.

#### 5.3.4 Performance and Scalability Testing

- **NFR-PERF-01:** measure editor actions (open editor, apply change, save, preview) using browser performance timing; pass when p95 ≤ 2.0 s over at least 30 samples per action per browser [Proposed].
- Concurrency for editor measurement: 1, 10 and 25 simultaneous QA users [Proposed – Q-04].
- **NFR-SCAL-01:** PRD gives no numeric target. Proposed baseline: generate synthetic visitor traffic against the QA test website ramping to 200 visitors/second for 30 minutes and verify experiment delivery, reporting accuracy and test-website page-load impact [Proposed – Q-04].
- Load generation targets only QA-owned assets, never other customers, and runs only after written approval from VWO and within an agreed window (R-05).

#### 5.3.5 Security Testing

- 2FA: enrolment, login with valid/invalid/expired code, recovery codes, admin-enforced 2FA, lockout behavior [TBC thresholds].
- RBAC: every role in Section 6.5 tested for allowed and denied actions through the UI and, where available, direct URL/API access.
- Activity logs: security-relevant actions (login, role change, experiment launch/stop, integration change) recorded with user, action and timestamp.
- Session management, password policy, logout and access after role revocation.
- OWASP Top 10 checks that are non-destructive; OWASP ZAP **passive baseline scan only** on production, with written authorization [Proposed].

#### 5.3.6 Data Privacy and Compliance Testing

- Consent: VWO tracking, heatmaps and recordings respect visitor consent/opt-out configuration on the test website.
- Masking: sensitive inputs (password, payment, email fields using synthetic data) are not visible in session recordings or heatmaps.
- Data subject rights: deletion and export requests for a synthetic visitor are fulfilled and verifiable.
- Data residency/regional policy behavior verified once regions are confirmed [TBC Q-06].

#### 5.3.7 Reliability Testing

- Synthetic monitors check https://vwo.com/ and https://app.vwo.com/ availability every 5 minutes during the test window [Proposed]; results are indicative evidence only, not a measurement of the contractual 99.9% SLA.
- Degradation behavior: when the VWO script is blocked or slow on the test website, the website still renders and the expected fallback (control) is shown [TBC expected behavior].
- Failover and disaster recovery are executed by VWO SRE, not QA (Section 3.2).

#### 5.3.8 Usability and Accessibility Testing

- Heuristic usability review of experiment creation, editor and reports for non-engineering personas (marketer, CRO specialist) [PRD target users].
- WCAG 2.1 AA [Proposed]: automated axe and Lighthouse scans plus manual keyboard navigation and screen-reader smoke tests (NVDA on Windows, VoiceOver on macOS/iOS).

#### 5.3.9 Cross-browser and Cross-device Testing

- Full functional suite on the primary browser (Chrome latest, Windows 11); smoke and critical-path suites on all other matrix entries (Section 6.2).
- Mobile web: verify experiment variations and personalized content render correctly for visitors on iOS Safari and Android Chrome.

#### 5.3.10 Statistical Accuracy Testing (SmartStats)

- Golden datasets with known visitor and conversion counts are replayed through controlled synthetic traffic.
- SmartStats outputs (e.g. probability to beat baseline, expected improvement range) are compared with an independent Bayesian beta-binomial computation; agreed tolerance ±1 percentage point [Proposed].
- A/A tests: no variation should be declared a winner [Proposed acceptance].
- Sample Ratio Mismatch check on every controlled test: chi-square test; p < 0.01 flags a traffic-allocation defect [Proposed].

### 5.4 Automation Strategy

| Layer | Tool | Scope | Target |
| --- | --- | --- | --- |
| UI end-to-end and regression | Playwright (TypeScript) | Smoke, critical paths, user flows, cross-browser | ≥ 70% of regression suite automated by Week 8 [Proposed] |
| API / integration | Postman / REST Assured | VWO APIs where available [TBC], connector data checks | All FR8 sync checks |
| Performance | k6 or JMeter | Editor timing harness, synthetic visitor traffic | NFR-PERF-01, NFR-SCAL-01 |
| Accessibility | axe DevTools / Lighthouse | Automated scans in CI | All primary screens |
| Statistical | Python or R scripts | Independent Bayesian computation, SRM check | All FR2 scenarios |
| CI/CD | GitHub Actions | Smoke on demand/release; nightly regression | Reports published per run |

Automation follows the conventions already used in this repository: page objects, condition-based waits, no fixed sleeps, credentials from a secret store, and isolated test data.

### 5.5 Production-Safety Rules

Testing on production [Stakeholder] creates risk to real customers and data. The following rules are mandatory [Proposed]:

1. Use only dedicated QA accounts/workspaces and QA-owned test websites. Never run experiments on real customer properties.
2. Prefix all test artefacts with **QA_AUTO_<yyyymmdd>_** and remove or archive them at the end of each cycle.
3. Use synthetic data only. No real personal data is entered or recorded.
4. Load, scalability and security scanning require written approval from VWO and an agreed time window.
5. No destructive actions on shared configuration (account-wide settings, billing, real integrations).
6. Stop testing immediately and escalate if any customer-facing impact is observed (Section 11).

## 6. Environment, Tools, Access, and Test Data

### 6.1 Test Environment

| Component | Detail | Source |
| --- | --- | --- |
| Public entry point | https://vwo.com/ – marketing site, sign-up and login entry | [Stakeholder] |
| Application | https://app.vwo.com/ – VWO platform | [PRD] |
| Environment type | Production (no separate QA/staging environment) | [Stakeholder] |
| QA test website(s) | QA-owned website(s) with the VWO tracking code installed, used as experiment, heatmap and personalization targets | [Proposed] – domain TBC |
| Third-party sandboxes | GA4, Mixpanel, Shopify dev store, Salesforce developer org, Segment, Snowflake trial, WordPress and Drupal sites | [Proposed] |
| VWO plan tier | Not provided – determines feature availability | [TBC Q-07] |

### 6.2 Browser, Device, and OS Matrix

Agreed matrix [Stakeholder]. Viewports: 1920×1080, 1366×768, 768×1024 (tablet), 375×812 (mobile).

| Operating system | Browser | Versions | Coverage level |
| --- | --- | --- | --- |
| Windows 11 | Chrome | Latest, Latest−1 | Primary – full suite |
| Windows 11 | Microsoft Edge | Latest, Latest−1 | Smoke + critical path |
| Windows 11 | Firefox | Latest, Latest−1 | Smoke + critical path |
| macOS (latest) | Safari | Latest | Smoke + critical path |
| macOS (latest) | Chrome | Latest | Smoke |
| iOS (latest) | Safari (mobile web) | Latest | Visitor-side experiment and personalization rendering |
| Android (latest) | Chrome (mobile web) | Latest | Visitor-side experiment and personalization rendering |

### 6.3 Tools

| Purpose | Tool [Proposed] |
| --- | --- |
| Test management and defect tracking | Jira with Xray or Zephyr |
| UI automation | Playwright (TypeScript); Selenium + Java framework available as an alternative |
| API testing | Postman, REST Assured |
| Performance / load | k6 or Apache JMeter |
| Security | OWASP ZAP (passive baseline scan) |
| Accessibility | axe DevTools, Lighthouse, NVDA, VoiceOver |
| Cross-browser cloud | BrowserStack |
| CI/CD | GitHub Actions |
| Statistical validation | Python (SciPy) or R |
| Secrets | GitHub Actions secrets or an approved vault |

### 6.4 Access and Accounts

- One dedicated QA user per role in Section 6.5, plus one custom-permission user, provisioned by the Account Admin before entry (Section 7.1).
- 2FA enabled on QA accounts; TOTP seeds stored in the secret store for automation.
- Credentials are never written into test cases, scripts, reports or this plan.
- Admin access to third-party sandboxes for the integration owner.

### 6.5 Role × Permission Matrix

Roles confirmed by stakeholder [Stakeholder]. The PRD does not define permissions per role, so every cell is **TBC** and must be completed from VWO account settings before security test design. QA will not assume any permission rule.

| Role | Create/edit experiment | Code editor (JS/CSS) | Launch/pause/stop | View reports | View recordings/heatmaps | Manage integrations | Manage users & roles |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Account Admin | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Account Owner | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Project Manager | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Marketer | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Experiment Creator | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Developer | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Analyst | TBC | TBC | TBC | TBC | TBC | TBC | TBC |
| Custom role | TBC | TBC | TBC | TBC | TBC | TBC | TBC |

### 6.6 Test Data

| Data set | Purpose | Source / rule |
| --- | --- | --- |
| Synthetic visitors | Drive experiments, heatmaps, recordings, personalization | Scripted traffic generator against QA test website |
| Golden SmartStats datasets | FR2 statistical validation | Pre-computed visitor/conversion counts with independent expected results |
| Audience attributes | FR5/FR7 segmentation | Synthetic geography (proxy/VPN locations), device, behavior, custom attributes |
| Sensitive-field data | Privacy masking checks | Synthetic only: test card 4111 1111 1111 1111, emails @example.com |
| Integration events | FR8 sync checks | Generated in sandboxes; no production customer data |
| User accounts | RBAC, 2FA | One QA account per role; secrets in vault |

Clean-up: all QA_AUTO_ artefacts archived or deleted at the end of each cycle; synthetic visitor data deletion requests raised where applicable.

## 7. Entry and Exit Criteria

All thresholds in this section are **[Proposed]** and become binding once approved in Section 12.

### 7.1 Entry Criteria

| # | Criterion | Measure |
| --- | --- | --- |
| EN-01 | Test plan approved | Signed in Section 12 |
| EN-02 | QA accounts provisioned for all roles with 2FA | 8 of 8 accounts verified by login |
| EN-03 | QA test website live with VWO tracking code | Tracking verified in VWO for a test visit |
| EN-04 | Third-party sandboxes available | 8 of 8 connectors reachable |
| EN-05 | Role × permission matrix completed | 0 TBC cells in Section 6.5 |
| EN-06 | Test cases reviewed and traced | 100% of FR/NFR rows linked to ≥ 1 reviewed case |
| EN-07 | Smoke suite passes on production | 100% smoke pass |
| EN-08 | Written approval for load and security scans | Approval reference recorded |

### 7.2 Exit Criteria

| # | Criterion | Measure |
| --- | --- | --- |
| EX-01 | Planned test execution complete | 100% of Must/High scenarios executed; ≥ 95% of all planned cases executed |
| EX-02 | Pass rate | ≥ 95% overall; 100% for Must-priority critical paths (UF-5.1, UF-5.2) |
| EX-03 | Open defects | 0 open Critical or High; Medium only with workaround and Product Owner acceptance |
| EX-04 | Performance | NFR-PERF-01 p95 ≤ 2.0 s for all measured editor actions |
| EX-05 | Security and privacy | 0 open Critical/High security or privacy findings |
| EX-06 | Accessibility | 0 open WCAG 2.1 A/AA blocker issues on primary workflows |
| EX-07 | Statistical accuracy | All golden datasets within ±1 pp tolerance; A/A tests with no false winner; no unexplained SRM |
| EX-08 | Traceability | 100% of FR1–FR9 and NFR rows have executed coverage |
| EX-09 | Reporting | Test summary report reviewed and signed |

## 8. Roles, Responsibilities, Estimates, and Schedule

### 8.1 Team and Responsibilities

Team composition is [Proposed] and assumes full-time allocation for the 8-week window.

| Role | Count | Responsibilities |
| --- | --- | --- |
| QA Lead | 1 | Plan ownership, estimation, risk management, triage chairing, reporting, sign-off coordination |
| QA Engineer (functional) | 3 | Test design and execution for FR1–FR9, integrations, privacy, accessibility, cross-browser |
| Automation Engineer | 1 | Playwright framework, smoke and regression automation, CI pipeline |
| Performance / Security Engineer | 1 | NFR-PERF, NFR-SCAL, security and statistical-accuracy tooling |
| Product Manager | — | Requirement clarification, acceptance criteria, defect priority, approval |
| Engineering Manager | — | Defect resolution, release information, approval |
| VWO Account Admin | — | Account, role and 2FA provisioning; integration credentials |
| DevOps / SRE | — | Approval windows for load testing; availability data |

### 8.2 RACI Matrix

R = Responsible, A = Accountable, C = Consulted, I = Informed.

| Activity | QA Lead | QA Eng. | Automation | Perf/Sec | Product Mgr | Eng. Mgr |
| --- | --- | --- | --- | --- | --- | --- |
| Test plan | A/R | C | C | C | C | C |
| Test design | A | R | C | R | C | I |
| Functional execution | A | R | I | I | I | I |
| Automation | A | C | R | C | I | I |
| Non-functional testing | A | C | C | R | I | C |
| Defect triage | A/R | R | C | C | R | R |
| Status reporting | A/R | C | C | C | I | I |
| Release sign-off | R | I | I | I | A | R |

### 8.3 Schedule

Proposed 8-week schedule starting Monday 12 October 2026 [Proposed].

| Week | Dates | Phase | Key outputs |
| --- | --- | --- | --- |
| 1 | 12 Oct – 16 Oct 2026 | Planning and setup | Approved plan; accounts, 2FA, test website, sandboxes; permission matrix |
| 2 | 19 Oct – 23 Oct 2026 | Test design | Test cases, test data, golden datasets, automation framework skeleton |
| 3–4 | 26 Oct – 06 Nov 2026 | Execution cycle 1 | Functional and integration execution; smoke automation; defects raised |
| 5 | 09 Nov – 13 Nov 2026 | Non-functional testing | Performance, security, privacy, accessibility results |
| 6 | 16 Nov – 20 Nov 2026 | Execution cycle 2 | Retests, cross-browser, statistical accuracy |
| 7 | 23 Nov – 27 Nov 2026 | Regression | Full regression; reliability monitoring summary |
| 8 | 30 Nov – 04 Dec 2026 | UAT support and closure | Test summary report, sign-off |

### 8.4 Effort Estimate

Estimates are [Proposed] in person-days (PD). Capacity: 6 people × 40 working days = 240 PD.

| Phase | Estimated effort (PD) | Basis |
| --- | --- | --- |
| Planning and setup | 18 | Accounts, environments, sandboxes, matrix |
| Test design | 32 | Approx. 300 test cases across FR1–FR9 and NFRs |
| Execution cycle 1 | 58 | Functional + integration, 3 QA engineers × 2 weeks plus support |
| Non-functional testing | 30 | Performance, security, privacy, accessibility |
| Execution cycle 2 | 30 | Retests, cross-browser, statistical |
| Regression | 26 | Automated + manual regression |
| UAT support and closure | 16 | Reporting and sign-off |
| Contingency (≈ 13%) | 30 | Defect retests, environment issues |
| Total | 240 |   |

## 9. Defect Management and Reporting

### 9.1 Defect Lifecycle

Tool: Jira [Proposed]. Lifecycle: **New → Triaged → Assigned → In Progress → Fixed → Ready for Retest → Verified → Closed**. Alternative outcomes: Reopened (retest failed), Rejected, Duplicate, Deferred (Product Owner approval required).

### 9.2 Severity Definitions

| Severity | Definition | VWO examples |
| --- | --- | --- |
| S1 – Critical | Core function unusable, data loss/corruption, security or privacy breach; no workaround | Experiment cannot launch; SmartStats declares wrong winner; unmasked personal data in recordings; RBAC bypass |
| S2 – High | Major function impaired; workaround is difficult | Wrong traffic split; integration stops syncing; editor changes not saved |
| S3 – Medium | Partial loss of function; reasonable workaround exists | Report filter incorrect; Kanban state not refreshed |
| S4 – Low | Cosmetic or minor usability issue | Alignment, label typo |

### 9.3 Priority and Proposed Fix Targets

| Priority | Meaning | Target to fix [Proposed] |
| --- | --- | --- |
| P1 | Fix immediately; blocks testing or release | 24 hours |
| P2 | Fix in current cycle | 3 working days |
| P3 | Fix before release if capacity allows | Before exit |
| P4 | Backlog | Planned release |

### 9.4 Defect Report Content

Each defect contains: ID, title, module/requirement ID, environment (browser, OS, viewport), role used, preconditions, synthetic test data, steps to reproduce, expected result, actual result, evidence (screenshot/video/HAR, with personal data removed), severity, priority, and reproduction status.

### 9.5 Triage

- Daily 15-minute triage during execution weeks: QA Lead (chair), Product Manager, Engineering Manager.
- S1 defects escalated immediately, outside the triage cycle.
- Security and privacy defects restricted to need-to-know visibility.

### 9.6 Reporting Cadence and Metrics

| Report | Frequency | Audience | Content |
| --- | --- | --- | --- |
| Daily status | Daily (execution weeks) | Project team | Executed/passed/failed/blocked, new S1/S2 defects, blockers |
| Weekly report | Weekly | Stakeholders | Progress vs plan, defect trends, risks, NFR results |
| Cycle report | End of each cycle | Stakeholders | Coverage, pass rate, open defects, recommendations |
| Test summary report | Once, Week 8 | Approvers | Final results vs exit criteria, residual risk, go/no-go recommendation |

Metrics: execution progress, pass rate, defects by severity/module/age, defect reopen rate, defect leakage, automation coverage, requirement coverage, NFR measurements.

## 10. Risks, Dependencies, Assumptions, and Open Questions

### 10.1 Risk Register

| ID | Risk | Likelihood | Impact | Mitigation | Owner |
| --- | --- | --- | --- | --- | --- |
| R-01 | Technical complexity of experiment setup leads to defects in editors and targeting [PRD] | Medium | High | Deep FR3/FR5 coverage; decision tables; code-editor edge cases | QA Lead |
| R-02 | Data accuracy issues in SmartStats and reports [PRD] | Medium | High | Independent statistical validation, A/A tests, SRM checks, cross-tool validation via integrations | Perf/Sec Eng. |
| R-03 | Low user adoption due to usability [PRD] | Medium | Medium | Usability heuristic review for non-engineering personas; accessibility testing | QA Eng. |
| R-04 | Production-only environment: test activity could affect real customers or data | Medium | High | Production-safety rules (5.5); isolated QA accounts and websites; suspension trigger | QA Lead |
| R-05 | Load and security scanning on production not permitted or breaches terms of service | High | High | Obtain written approval before Week 5; otherwise mark NFR-SCAL-01 as not tested and record residual risk | QA Lead |
| R-06 | Role permissions undocumented | High | High | Complete matrix (6.5) in Week 1 from account settings; entry criterion EN-05 | Product Mgr |
| R-07 | Insufficient real traffic for statistically meaningful experiments | High | Medium | Synthetic traffic generator and golden datasets | Automation Eng. |
| R-08 | Third-party sandbox unavailability or rate limits | Medium | Medium | Provision in Week 1; schedule integration tests flexibly | QA Eng. |
| R-09 | Frequent SaaS releases change UI during the window | Medium | Medium | Stable locators, smoke suite on each release, release notes subscription | Automation Eng. |
| R-10 | Plan tier lacks features under test | Medium | High | Confirm tier (Q-07) in Week 1; descope with approval | Product Mgr |
| R-11 | Residual QA data on production | Medium | Low | QA_AUTO_ naming and end-of-cycle clean-up | QA Eng. |

### 10.2 Dependencies

- VWO Account Admin provisions QA accounts for all roles and enables 2FA (Week 1).
- QA-owned test website(s) hosted and tagged with the VWO tracking code.
- Sandbox accounts for all FR8 connectors.
- Written approval from VWO / DevOps for load and passive security scans.
- Product Manager availability for clarification and daily triage.
- Access to VWO documentation (REF-03) for expected behavior.

### 10.3 Assumptions

| ID | Assumption |
| --- | --- |
| A-01 | QA has a dedicated VWO account/workspace isolated from real customer campaigns. |
| A-02 | All features FR1–FR9 are enabled on the QA account’s plan tier. |
| A-03 | Synthetic traffic to QA-owned websites is permitted by VWO terms of use. |
| A-04 | The proposed team and schedule are accepted; changes trigger re-planning. |
| A-05 | VWO releases during the window are announced in advance through release notes. |
| A-06 | VWO documentation is the reference for expected behavior not specified in the PRD. |

### 10.4 Open Questions

| ID | Question | Impact if unresolved | Owner |
| --- | --- | --- | --- |
| Q-01 | Which product version/release is under test, and what is the release cadence? | Regression scope and schedule | Eng. Mgr |
| Q-02 | What are the exact permissions for each role, including custom roles? | RBAC tests cannot be designed (EN-05) | Product Mgr |
| Q-03 | What latency defines “real-time” for reports (FR6)? | FR6 pass/fail threshold | Product Mgr |
| Q-04 | What visitor volume and editor concurrency define “high volume” (NFR-SCAL-01, NFR-PERF-01)? | Load test targets | Product Mgr / SRE |
| Q-05 | How should personalization interact with a running A/B test for the same visitor? | TS-FR7-03 expected result | Product Mgr |
| Q-06 | Which data residency regions and regional policies apply? | Privacy test scope | Privacy Officer |
| Q-07 | Which plan tier (Growth / Pro / Enterprise) does the QA account have? | Feature availability | Account Owner |
| Q-08 | Is load and passive security scanning on production approved? | NFR-SCAL-01 and security coverage | Eng. Mgr / SRE |
| Q-09 | Is WCAG 2.1 AA the agreed accessibility target? | Accessibility exit criterion | Product Mgr |
| Q-10 | What is the expected visitor experience when the VWO script fails to load? | Reliability expected result | Eng. Mgr |

## 11. Suspension and Resumption Criteria

### 11.1 Suspension Criteria

Testing (fully or for the affected area) is suspended when any of the following occurs [Proposed]:

| # | Trigger |
| --- | --- |
| SU-01 | Any observed impact on real customers, customer data or production stability caused by test activity – immediate stop and escalation. |
| SU-02 | A security or privacy exposure is discovered (for example, unmasked personal data) – stop the affected area and escalate to the Privacy/Security owner. |
| SU-03 | https://app.vwo.com/ or login unavailable for more than 2 hours during test hours. |
| SU-04 | An open S1 defect blocks more than 30% of the planned cases for the current cycle. |
| SU-05 | QA test website, QA accounts or required sandboxes are unavailable for more than 1 working day. |
| SU-06 | An unannounced VWO release changes the application under test mid-cycle. |

### 11.2 Resumption Criteria

- Root cause of the suspension is resolved and confirmed by the responsible owner.
- Smoke suite passes 100% on the current release.
- QA Lead and Product Manager agree to resume; affected tests are re-planned and the schedule impact is recorded.
- For SU-01/SU-02: written clearance from Engineering Manager and Privacy/Security owner.

## 12. Test Deliverables and Approval

### 12.1 Test Deliverables

| Deliverable | Timing | Owner |
| --- | --- | --- |
| Software Test Plan (this document) | Week 1 | QA Lead |
| Test scenarios and test cases (Jira Xray/Zephyr) | Week 2 | QA Engineers |
| Requirements Traceability Matrix | Week 2, updated each cycle | QA Lead |
| Test data sets and golden SmartStats datasets | Week 2 | QA / Perf-Sec Eng. |
| Automation suite and CI pipeline | Weeks 2–8 | Automation Engineer |
| Daily and weekly status reports | Weeks 3–8 | QA Lead |
| Defect reports | Continuous | QA Engineers |
| Performance, security, privacy, accessibility and statistical accuracy reports | Weeks 5–6 | Perf/Sec Eng., QA Engineers |
| Cycle reports | End of Weeks 4, 6, 7 | QA Lead |
| Test Summary Report with go/no-go recommendation | Week 8 | QA Lead |

### 12.2 Approval

By signing, approvers accept the scope, approach, proposed thresholds and schedule in this plan. Items marked [TBC] remain open and are tracked in Section 10.4.

| Role | Name | Signature | Date |
| --- | --- | --- | --- |
| QA Lead |   |   |   |
| Product Manager |   |   |   |
| Engineering Manager |   |   |   |
| Security / Privacy Officer |   |   |   |

## Appendix A – Glossary

| Term | Definition |
| --- | --- |
| A/B test | Controlled experiment comparing variants [PRD] |
| A/A test | Experiment with identical variants, used to validate the statistics engine |
| CRO | Conversion Rate Optimization [PRD] |
| DXO | Digital Experience Optimization [PRD] |
| MVT | Multivariate test – tests combinations of changes to several elements |
| Split URL test | Experiment where variations are served from different URLs |
| SmartStats | VWO Bayesian statistical engine for experiment results [PRD] |
| SRM | Sample Ratio Mismatch – observed traffic split differs significantly from the configured split |
| RBAC | Role-based access control |
| 2FA | Two-factor authentication |
| p95 | 95th percentile of measured response times |
| RTM | Requirements Traceability Matrix |
| WCAG | Web Content Accessibility Guidelines |

## Appendix B – Test Type × Module Coverage Heat-map

Planned test depth per module [Proposed]: H = high, M = medium, L = light, – = not applicable.

| Module | Func. | Integ. | Regr. | Perf. | Sec. | Privacy | Reliab. | A11y/UX | X-browser | Stats |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| FR1 Experiments | H | M | H | M | M | L | M | M | H | M |
| FR2 SmartStats | H | M | H | L | L | L | L | L | L | H |
| FR3 Editors | H | L | H | H | M | L | L | H | H | – |
| FR4 Insights | H | M | H | M | M | H | M | M | H | – |
| FR5 Targeting | H | M | H | L | L | M | L | M | M | – |
| FR6 Reporting | H | M | H | H | M | L | M | M | M | H |
| FR7 Personalization | H | M | M | M | L | H | M | M | H | – |
| FR8 Integrations | M | H | H | L | H | M | M | L | L | – |
| FR9 Workflow | M | L | M | L | H | L | L | M | M | – |

Security for FR9 is rated high because workflow and collaboration actions are the primary surface for role-based access checks.
