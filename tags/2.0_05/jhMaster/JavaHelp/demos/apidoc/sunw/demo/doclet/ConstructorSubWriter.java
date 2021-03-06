/*
 * @(#)ConstructorSubWriter.java	1.5 06/10/30
 * 
 * Copyright (c) 2006 Sun Microsystems, Inc.  All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the
 *   distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL
 * NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR
 * ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL,
 * CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND
 * REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF OR
 * INABILITY TO USE THIS SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility. 
 */

/*
 * @(#) ConstructorSubWriter.java 1.5 - last change made 10/30/06
 *
 * (c) 1997-1998 Sun Microsystems, Inc.  All rights reserved.  Use is
 * subject to license terms. Sun, Sun Microsystems, the Sun Logo, Solaris,
 * Java, the Java Coffee Cup Logo, and JavaHelp are trademarks or registered
 * trademarks of Sun Microsystems, Inc. in  the U.S. and other countries.
 *
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 */

package sunw.demo.doclet;

import com.sun.javadoc.*;

/**
 * This method prints out Constructor documentation for a class
 *
 * @author Roger D. Brinkley
 * @version	1.5	10/30/06
*/

public class ConstructorSubWriter extends ExecutableMemberSubWriter {

    ConstructorSubWriter(HtmlWriter writer) {
        super(writer);
    }

    public ProgramElementDoc[] members(ClassDoc cd) {
        return cd.constructors();
    }

    public void printSummaryLabel(ClassDoc cd) {
        writer.boldText("doclet.Constructor_Summary"); 
    }

    public void printInheritedSummaryLabel(ClassDoc cd) {
        // no such
    }

    protected void printSummaryType(ProgramElementDoc member) {
        // no such
    }

    protected void printTags(ProgramElementDoc member) {
        ParamTag[] params = ((ConstructorDoc)member).paramTags();
        ThrowsTag[] thrown = ((ConstructorDoc)member).throwsTags();
        SeeTag[] sees = member.seeTags();
        if (params.length + thrown.length + sees.length > 0) {
            writer.dd();
            writer.dl();
            printParamTags(params);
            printThrowsTags(thrown);
            writer.printSeeTags(member);
            writer.dlEnd();
            writer.ddEnd();
        }
    }
                               
    protected void printHeader(ClassDoc cd) {
        writer.anchor("constructors");
        //writer.printIndexHeading(writer.getText("doclet.Constructors"));
        writer.printTableHeadingBackground(writer.getText("doclet.Constructors"));
    }
}  
    
    
