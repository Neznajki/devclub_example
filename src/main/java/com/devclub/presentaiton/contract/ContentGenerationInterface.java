package com.devclub.presentaiton.contract;

public interface ContentGenerationInterface extends
        ContentGenerationIndexInterface,
        ContentGenerationHtmlReceiverInterface,
        ContentCollectionContainerInterface
{
    String adjustContent(String content, String formId);
}
