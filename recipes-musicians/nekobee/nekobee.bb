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

SRC_URI = "git://github.com/gordonjcp/${BPN}.git"
SRCREV = "593d4be0ff6b4279e1b2b1bacbd5b6b02221358a"
S = "${WORKDIR}/git"
PV = "0.2+git${SRCPV}"

waf_preconfigure() {
}

do_configure_prepend() {
    cd ${S}

    # link python -> python3
    ln -sf `which python3` ${B}/python
    export PATH="${PATH}:${B}"

    # dummy call -> unpacks waf
    ./waf configure -o ${B} --prefix=${prefix} ${EXTRA_OECONF} || true

    # -> python3
    2to3 -w -x import `find .waf3-* -name '*.py'`

    ./waf configure --prefix=${prefix} ${WAF_EXTRA_CONF} ${EXTRA_OECONF}
}

do_compile()  {
    export PATH="${PATH}:${B}"

    # waf breaks but gets far enough to build what's necessary
	${S}/waf build ${@oe.utils.parallel_make_argument(d, '-j%d', limit=64)} || true
}

do_install()  {
    install -d ${D}${libdir}/dssi/nekobee
    install -m 0644 ${B}/build/default/nekobee.so ${D}${libdir}/dssi/
    install -m 0755 ${B}/build/default/nekobee_gtk ${D}${libdir}/dssi/nekobee/
    install -m 0644 ${B}/extra/knob.png ${D}${libdir}/dssi/nekobee/
    install -m 0644 ${B}/extra/switch.png ${D}${libdir}/dssi/nekobee/
}

FILES_${PN} += " \
    ${libdir}/dssi \
"
