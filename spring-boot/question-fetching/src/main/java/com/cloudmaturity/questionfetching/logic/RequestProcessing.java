package com.cloudmaturity.questionfetching.logic;

import com.cloudmaturity.questionfetching.objects.Questions;
import com.cloudmaturity.questionfetching.objects.Request;

import java.util.Locale;

public class RequestProcessing
{

    public RequestProcessing() {}

    public Questions processRequest(Request request)
    {
        switch(request.getCategory().toLowerCase())
        {
            case "culture":
                return cultureQuestions();
            case "prodservicedesign":
                return prodDesignServiceQuestions();
            case "team":
                return teamQuestions();
            case "process":
                return processQuestions();
            case "architecture":
                return architectureQuestions();
            case "maintenance":
                return maintenanceQuestions();
            case "delivery":
                return deliveryQuestions();
            case "provisioning":
                return provisioningQuestions();
            case "infrastructure":
                return infrastructureQuestions();
        }
        return new Questions();
    }

    private Questions cultureQuestions ()
    {
        return new Questions
                (
                        "Do you have a collaborative culture (e.g big but not specific/highly detailed goals with" +
                                " no fixed delivery dates)?",
                        "Project Managers coordinate between all the different teams working on the same project," +
                                " and the teams have highly specialised responsibilities.",
                        "Our development teams focus on achieving small, defined objectives quickly and then" +
                                " moving immediately to the next one.",
                        "A lot of up-front planning goes into documenting each step of a project before it even begins.",
                        "Each team contain a mix of members whose different areas of expertise cover the full" +
                                " spectrum of skills needed for crafting a releasable increment."
                );
    }

    private Questions prodDesignServiceQuestions()
    {
        return new Questions
                (
                        "Is your product and design data driven- that is are they rapidly prototyped, deployed and " +
                                "evaluated based on real customer usage before deciding on further" +
                                " development or retirement",
                        "We have product roadmaps spanning months or even years into the future. Our releases" +
                                " typically happen every six months to one year, sometimes even longer.",
                        "There is pressure to deliver features, fast, and releases happen on a regular planned basis." +
                                " (For example, \"We'll Feature X in two months, Feature Y in four months and " +
                                "Feature Z in six months\" -with no deviation from the schedule).",
                        "We release large sets of related features all at once as comprehensive updates.",
                        "Our releases are usually small-scale iterative changes to existing features/services."
                );
    }

    private Questions teamQuestions()
    {
        return new Questions
                (
                        "Are teams Devops teams that are self contained teams, responsible for all development" +
                                " and deployment to production and production is monitored by SRE teams?",
                        "All decisions are made by managers, and teams must seek permission before changing" +
                                " any part of the project plan, no matter how small.",
                        "Applications are developed as several large components, with one team per component" +
                                " fully and vertically responsible for the build.",
                        "We have separate teams of specialists to handle different areas: design, architecture," +
                                " security, testing, etc. When our team's piece of a project is finished, we hand" +
                                " it off to the next team.",
                        "Our teams are mixed: We have developers, QA/testng, someone with server experience ,etc." +
                                " all in one group. We don't talk to other teams very much since our teams are" +
                                " meant to be self-sufficient and independent."
                );
    }

    private Questions processQuestions()
    {
        return new Questions
                (
                        "Do you use research and experimentation techniques for large and complex problems" +
                                " - using lots of proof of concepts to compare options, using Kanban to clarify" +
                                " the project then Agile methods like Scrum once a problem is well understood?",
                        "We do all our planning up front, and then hand off to teams for execution." +
                                " Managers handle the collaboration and communication between our teams.",
                        "A team will work on one small, defined project and deliver it in two to four weeks." +
                                " If a new feature request comes in the middle of a delivery cycle, we may" +
                                " or may not be able to add it in",
                        "If a new feature request comes in the middle of a delivery cycle, we have to wait for" +
                                " the next cycle to plan for and incorporate it.",
                        "If we can't coordinate or fix an issue on the last day or two of a production cycle, we" +
                                " can't ship - so when a bug or some other problem pops up it's hard to do anything" +
                                " more than a quick fix. (Following up to address an issue in more depth requires" +
                                " a dedicated sprint so we can focus on it)."
                );
    }

    private Questions architectureQuestions()
    {
        return new Questions
                (
                        "Do you have a microprocessor architecture built from independently deployable services?",
                        "Our system is very big. Few people understand the whole thing. We fear the domino effect:" +
                                " If you change something, you have to be very careful because it" +
                                " could break something else.",
                        "Our application(s) is(are) divided into components, probably no more than five or six," +
                                " communicating through networking.",
                        "When we deliver, everything is delivered together, all ready on the same day and" +
                                " at a uniformly high level of quality.",
                        "The scope of an app development is defined by the deployment schedule. Each" +
                                " feature or piece of functionality is broken down into deliverable chunks" +
                                " that fit into the schedule."
                );
    }

    private Questions maintenanceQuestions()
    {
        return new Questions
                (
                        "Does your system collect metrics, alerts tracing and logging to provide a view of the" +
                                " running system and try to keep itself alive through self healing if things" +
                                " begin to deteriorate?",
                        "We have some simple automation, like scripts, for alerting large-scale issues" +
                                " and outages in the field. We find out about many smaller problems from user reports.",
                        "Our systems have full and continuous monitoring, and our Ops team spends lots of time" +
                                " checking on alerts. A lot of time, our system alerts turn out to be nothing.",
                        "When problems arise, we have to open each server to understand what happened because we" +
                                " don't have central logs or tracing. Then we fix it manually: someone from" +
                                " Operations logs into a production server and follows a preset procedure.",
                        "Some of our system update processes are fully automated and patches can be applied" +
                                " quickly - but a human still has to initialise the process."
                );
    }

    private Questions deliveryQuestions()
    {
        return new Questions
                (
                        "Do you deliver your releasable software multiple times a day?",
                        "We do \"big bang\" releases that roll lots of changes into one new version, every six" +
                                " to 12 months. A lot of up-front planning goes into our next release before any" +
                                " actual development begins.",
                        "Our delivery process includes some test automation and automated build, but outside" +
                                " of final integration. In an emergency, we can make manual updates to the" +
                                " production codebase.",
                        "We don't like to make changes to our production code, even emergency ones, because" +
                                " there are so many dependencies. Change is risky. Once we release a software" +
                                " version all changes have to wait for the next version roll out.",
                        "New functionality requests typically can be accommodated within a few weeks," +
                                " if they are urgent."
                );
    }

    private Questions provisioningQuestions()
    {
        return new Questions
                (
                        "Do you run on Kubernetes?",
                        "Operations team is in charge of provisioning, period. You have to write a ticket to" +
                                " provision a machine - engineers can't self-service.",
                        "A machine can be provisioned (possible even auto-provisioned) in hours, or maybe a day" +
                                " or two, and the process is fully automated by Ops.",
                        "Developers write applications, and specify what they will need to run successfully" +
                                " in production (OS, libraries, dependent tools). The ops team manually configures" +
                                " the production machines to meet the machine dependencies the Dev team specified.",
                        "Provisioning is a mix of automation and manual work. Any task taking longer than a week" +
                                " to provision to VM breaks the production cycle, so is a nonstarter."
                );
    }

    private Questions infrastructureQuestions()
    {
        return new Questions
                (
                        "Do you deploy your software in containers?",
                        "We have multiple physical servers in our own private data center" +
                                " (either on premises or co-located). If one of our servers goes down, we" +
                                " have to manually provision its replacement.",
                        "We don't use physical servers - we have VMs. We also have some instances" +
                                " in the cloud, which we manage manually.",
                        "A data centre failure is just about the worst disaster we can imagine.",
                        "Provisioning infrastructure is a mix of automation and manual work," +
                                " so a new VM can take a couple of days to set up."
                );
    }
}
