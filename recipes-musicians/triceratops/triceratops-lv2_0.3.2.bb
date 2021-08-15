SUMMARY = "Polyphonic synthesizer LV2 plugin"
HOMEPAGE = "http://thunderox.com/thor/?q=node/2"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += " \
    gtkmm \
    jack \
    lv2 \
    liblo \
"

inherit waf pkgconfig python3native

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/project/triceratops/triceratops_${PV}.tar.gz;subdir=${BPN}-${PV} \
    file://0001-wscript-Start-python3-support.patch \
"
SRC_URI[md5sum] = "8f3ea6902cd8bf90f6337c2c4f531b8d"
SRC_URI[sha256sum] = "8056b9e2dbfe3cd5b8e30eb28f5ce2a4f34e272c8bf5c897d02410b905fa91ed"

EXTRA_OECONF = "\
    --libdir=${libdir} \
"

waf_preconfigure() {
}

do_configure:prepend() {
    cd ${S}

    # link python -> python3
    ln -sf `which python3` ${B}/python
    export PATH="${PATH}:${B}"

    # dummy call -> unpacks waf
    ./waf configure -o ${B} --prefix=${prefix} ${EXTRA_OECONF} || true

    for py in `find .waf3-* -name '*.py'`; do

        # -> python3
        2to3 -w -x import $py

        # hmmm
        sed -i 's:^.*raise StopIteration::g' $py

    done

    ./waf configure --prefix=${prefix} ${WAF_EXTRA_CONF} ${EXTRA_OECONF}
}

do_compile()  {
    export PATH="${PATH}:${B}"

    # waf breaks but gets far enough to build what's necessary
	(cd ${S} && ./waf build ${@oe.utils.parallel_make_argument(d, '-j%d', limit=64)}) || true
}

do_install()  {
    export PATH="${PATH}:${B}"
	(cd ${S} && ./waf install --destdir=${D}) || true
}

FILES:${PN} += " \
    ${libdir}/lv2 \
"
