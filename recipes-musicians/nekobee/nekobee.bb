SUMMARY = "A softsynth recreation of a classic single-oscillator bass monosynth"
HOMEPAGE = "https://github.com/gordonjcp/nekobee"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

inherit wafold pkgconfig python3native

DEPENDS += " \
    gtk+ \
    ladspa-sdk \
    dssi \
    liblo \
"

SRC_URI = "git://github.com/schnitzeltony/${BPN}.git;branch=master;protocol=https"
SRCREV = "d5727e5902a6dd098bbee5a644dce317ef575328"
S = "${WORKDIR}/git"
PV = "0.2+git${SRCPV}"

waf_preconfigure() {
}

PATH:prepend = "${B}:"

do_configure:prepend() {
    # link python -> python3
    ln -sf `which python3` ${B}/python
}

FILES:${PN} += " \
    ${libdir}/dssi \
"
