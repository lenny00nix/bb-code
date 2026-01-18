function maketoc() {
    // Find the container.  If there isn't one, return silently.
    var iftoc = frames["iftoc"];
    if (!iftoc) return;
    var container = iftoc.document.getElementById('toc');
    if (!container) return;

    // Traverse the document, adding all <h1>...<h6> tags to an array
    var sections = [];
    var ifcontent = frames["ifcontent"];
    if (!ifcontent) return;
    findSections(ifcontent.document, sections);

    // Initialize an array that keeps track of section numbers
    var sectionNumbers = [0,0,0,0,0];
    var actMenus = [0,0,0,0,0,0];
    var prevLevel = -1;

    // Now loop through the section header elements we found
    for(var s = 0; s < sections.length; s++) {
        var section = sections[s];

        // Figure out what level heading it is
        var level = parseInt(section.tagName.charAt(1));
        if (isNaN(level) || level < 1 || level > 6) continue;

        level--;

        if(level > 0) {
           // Increment the section number for this heading level
           // And reset all lower heading level numbers to zero
           sectionNumbers[level-1]++;
           for(var i = level; i < 5; i++) sectionNumbers[i] = 0;

           // Now combine section numbers for all heading levels
           // to produce a section number like 2.3.1
           var sectionNumber = "";
           for(i = 0; i < level; i++) {
               sectionNumber += sectionNumbers[i];
               if (i < level-1) sectionNumber += ".";
           }

           // Add the section number and a space to the section header title.
           // We place the number in a <span> to make it styleable.
           var frag = document.createDocumentFragment(); // to hold span and space
           var span = document.createElement("span");    // span to hold number
           span.className = "TOCSectNum";                // make it styleable
           span.appendChild(document.createTextNode(sectionNumber)); // add sect#
           frag.appendChild(span);                         // Add span to fragment
           frag.appendChild(document.createTextNode(" ")); // Then add a space
           section.insertBefore(frag, section.firstChild); // Add both to header
        } else
           sectionNumber = 0;

        if(level > prevLevel+1) {
           var p = document.createElement("p");
           p.textContent = "[ broken chain of section numbers ]";
           section.appendChild(p);
           return;
        }

        // Create an anchor to mark the beginning of this section.
        var anchor = document.createElement("a");
        anchor.name = "TOC"+sectionNumber;  // Name the anchor so we can link
        anchor.id = "TOC"+sectionNumber;    // In IE generated anchors need ids

        // Insert the anchor and link immediately before the section header
        section.parentNode.insertBefore(anchor, section);

        // Now create a link to this section.
        var link = document.createElement("a");
        link.href = frames['ifcontent'].location+"#TOC" + sectionNumber;   // Set link destination
        link.target = "ifcontent";

        // Make link text same as heading
        if(section.innerText) {
           link.innerHTML = section.innerText;
        } else {
           link.innerHTML = section.textContent;
        }

        // Place the link in a div that is styleable based on the level
        var entry = document.createElement("li");
        entry.appendChild(link);

        if(level > prevLevel) {
            actMenus[level] = document.createElement("menu");
            if(level > 0) {
                actMenus[level-1].appendChild(actMenus[level]);
            } else {
                container.appendChild(actMenus[0]);
            }

        }
        // And add the div to the TOC container
        actMenus[level].appendChild(entry);
        prevLevel = level;
    }

    // This method recursively traverses the tree rooted at node n, looking
    // for <h1> through <h6> tags and appends them to the sections array.
    function findSections(n, sects) {
        // Loop through all the children of n
        for(var m = n.firstChild; m != null; m = m.nextSibling) {
            // Skip any  nodes that are not elements.
            if (m.nodeType != 1 /* Node.Element_NODE */) continue;
            // Skip the container element since it may have its own heading
            if (m == container) continue;
            // As an optimization, skip <p> tags since headings are not
            // supposed to appear inside paragraphs.  (We could also skip
            // lists, <pre> tags, etc., but <p> is the most common one.)
            if (m.tagName == "P") continue;  // optimization

            // If we didn't skip the child node, check whether it is a heading.
            // If so, add it to the array.  Otherwise, recurse on it.
            // Note that the DOM is interface-based not class-based so we
            // cannot simply test whether (m instanceof HTMLHeadingElement).
            if (m.tagName.length==2 && m.tagName.charAt(0)=="H") sects.push(m);
            else findSections(m, sects);
        }
    }
}

// Register maketoc() to run automatically when the document finishes loading
if (window.addEventListener) window.addEventListener("load", maketoc, false);
else if (window.attachEvent) window.attachEvent("onload", maketoc);
